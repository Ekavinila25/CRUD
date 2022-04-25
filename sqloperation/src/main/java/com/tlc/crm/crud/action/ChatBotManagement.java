package com.tlc.crm.crud.action;

import com.tlc.commons.json.Json;
import com.tlc.commons.json.JsonArray;
import com.tlc.commons.json.JsonObject;
import com.tlc.crm.crud.api.ChatBotManager;
import com.tlc.crm.crud.model.ChatBot;
import com.tlc.crm.common.action.secure.CrmConfigAction;
import com.tlc.crm.common.config.ConfigManager;

import com.tlc.crm.crud.validator.HibernateValidator;
import com.tlc.validator.type.Group.Update;
import com.tlc.validator.type.Group.Create;
import com.tlc.web.WebAction;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Api implementation
 *
 * @author KavinilaE
 */
@WebAction(path = "/chatbot/management")
public class ChatBotManagement extends CrmConfigAction<ChatBot> {

    /**
     * Returns the object for chatbotmanager.
     */
    @Override
    public  ConfigManager<ChatBot> getConfigManager() {
        return ChatBotManager.getInstance();
    }

    /**
     * Convert json object to chatbot object.
     *
     * @param jsonObject
     */
    @Override
    public ChatBot construct(final JsonObject jsonObject) {
        final Long id = jsonObject.optLong("id", 0);
        final String question = jsonObject.optString("question", null);
        final String answer = jsonObject.optString("answer", null);
        final ChatBot chatBot = new ChatBot(id, question, answer);
        final String type = jsonObject.getString("data");

        if (type.equals("create") || type.equals("update")) {
            HibernateValidator.validate(chatBot, getGroups(type));
        }
        return chatBot;
    }

    /**
     * Gets group.
     */
    private Class getGroups(final String type) {
        if (type.equals("create")) {
            return Create.class;
        } else {
            return Update.class;
        }
    }

    /**
     * Convert chatbot object to json object.
     */
    public JsonObject construct(final ChatBot chatBot) {
        final JsonObject jsonObj = Json.object();

        jsonObj.put("id", chatBot.id());
        jsonObj.put("question", chatBot.getQuestion());
        jsonObj.put("answer", chatBot.getAnswer());
        return jsonObj;
    }

    @Override
    /**
     * Pass the collection of data.
     */
    public Collection<ChatBot> constructArray(final JsonObject data) {
        final Collection<ChatBot> chatBot = new ArrayList<>();
        final JsonArray dataArray = data.getJsonArray("seconddata");

        for (int index = 0; index < dataArray.size(); index++) {
            final JsonObject object = dataArray.getJsonObject(index);

            final Long id = object.optLong("id", 0);
            final String question = object.optString("question", null);
            final String answer = object.optString("answer", null);
            final String type = data.getString("type");
            final ChatBot conversation = new ChatBot(id, question, answer);

            try {

                if (type.equals("create") || type.equals("update")) {
                    HibernateValidator.validate(conversation, getGroups(type));
                }
                chatBot.add(conversation);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return chatBot;
    }
}