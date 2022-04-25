package com.tlc.crm.crud.model;

import com.tlc.crm.crud.validator.Answer;
import com.tlc.crm.crud.validator.Question;
import com.tlc.validator.type.Group.Update;
import com.tlc.validator.type.Group.Create;
import com.tlc.validator.TlcModel;

/**
 * Get and set the data.
 *
 * @author KavinilaE
 */
public class ChatBot implements TlcModel {

    private Long id;

    @Question(groups = {Create.class, Update.class})
    private String question;

    @Answer(groups = {Create.class, Update.class})
    private String answer;

    public ChatBot() {
    }

    public ChatBot(Long id, String question, String answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {return id;}

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public Long id() {
        return id;
    }

    @Override
    public Object identity() {
        return null;
    }
}
