package com.tlc.crm.crud.api;

import com.tlc.commons.code.ErrorCode;

import com.tlc.crm.common.config.AuditEntry;
import com.tlc.crm.common.config.ConfigManager;

import com.tlc.crm.crud.model.ChatBot;
import com.tlc.crm.crud.status.ChatErrorCode;

import com.tlc.sql.SQLAccess;
import com.tlc.sql.api.DataContainer;
import com.tlc.sql.api.Row;
import com.tlc.sql.api.dml.*;
import com.tlc.sql.api.ds.OrgDataStore;

import java.util.*;

/**
 * Provides Crud operation.
 *
 * @author KavinilaE
 */
public class ChatBotManager implements ConfigManager<ChatBot> {

    private static final Table TABLE = Table.get("ChatBot");
    private static final OrgDataStore ORG_DATA_STORE = getOrgDataStore();

    private ChatBotManager() {
    }

    /**
     * Get instance.
     */
    public static ChatBotManager getInstance() {
        return Instance.INSTANCE;
    }

    /**
     * Create instance.
     */
    private static class Instance {
        private static final ChatBotManager INSTANCE = new ChatBotManager();
    }

    /**
     * Get the value of orgdatastore.
     */
    private static OrgDataStore getOrgDataStore() {
        return SQLAccess.get().getOrgDataStore(1L);
    }

    /**
     * Inserts the new record.
     *
     * @param chatBot
     */
    @Override
    public void create(final ChatBot chatBot) {
    }

    @Override
    public void create(final Collection<ChatBot> models) {
       final DataContainer dataContainer = DataContainer.create();

        for (ChatBot chatBot : models) {
            final Row row = new Row(TABLE);

            row.set("QUESTION", chatBot.getQuestion());
            row.set("ANSWER", chatBot.getAnswer());
            dataContainer.addNewRow(row);

            ORG_DATA_STORE.commitChanges(dataContainer);
        }
    }

    /**
     * Updates the record.
     *
     * @param chatBot
     */
    public void update(final ChatBot chatBot) {
        final Row row = new Row(TABLE, chatBot.id());
        final DataContainer dataContainer = DataContainer.create();

        if (exists(chatBot)) {
            setColumns(row, chatBot);
            dataContainer.updateRow(row);
            ORG_DATA_STORE.commitChanges(dataContainer);
        } else {
            throw ErrorCode.get(ChatErrorCode.FAILED_TO_UPDATE_RECORD);
        }
    }

    /**
     * Set the value.
     *
     * @param row
     * @param chatBot
     */
    public void setColumns(final Row row, final ChatBot chatBot) {
        row.set("QUESTION", chatBot.getQuestion());
        row.set("ANSWER", chatBot.getAnswer());
    }

    /**
     * Fetches the record.
     *
     * @param id
     */
    @Override
    public ChatBot get(final Long id) {
        final Row row = ORG_DATA_STORE.get(TABLE, id);
        final ChatBot chatBot = new ChatBot();

        chatBot.setId(row.get("ID"));
        chatBot.setQuestion(row.get("QUESTION"));
        chatBot.setAnswer(row.get("ANSWER"));
        return chatBot;
    }

    /**
     * Deletes the record.
     *
     * @param model
     */
    @Override
    public void delete(final ChatBot model) {
        final Collection<ChatBot> chatBot = new HashSet<>();

        chatBot.add(model);
        if (exists(model)) {
            delete(chatBot);
        } else {
            throw ErrorCode.get(ChatErrorCode.FAILED_TO_DELETE_RECORD);
        }
    }

    /**
     * Deletes the records.
     *
     * @param models
     */
    @Override
    public void delete(final Collection<ChatBot> models) {
        final Collection<Long> id = new HashSet<>();

        models.forEach(questionId -> id.add(questionId.id()));
        ORG_DATA_STORE.delete(TABLE, id);
    }

    /**
     * Get the value by id.
     *
     * @param id
     */
    @Override
    public ChatBot partialGet(final Long id) {
        final ChatBot chatBot = new ChatBot();

        chatBot.setId(id);
        return chatBot;
    }

    /**
     * Checks the record is already present or not.
     *
     * @param model
     */
    @Override
    public boolean exists(final ChatBot model) {
        return ORG_DATA_STORE.get(TABLE, model.getId()) != null ? true : false;
    }

    @Override
    public Collection<ChatBot> get(final Collection<Long> id) {
        return null;
    }

    @Override
    public AuditEntry auditEntry(final ChatBot model) {
        return null;
    }
}
