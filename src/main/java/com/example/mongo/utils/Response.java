package com.example.mongo.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder(toBuilder = true)
public class Response {
    private Object messageBody;
    private int codeMessage;
    private String message;
    private Boolean state;

    public Object getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(Object messageBody) {
        this.messageBody = messageBody;
    }

    public int getCodeMessage() {
        return codeMessage;
    }

    public void setCodeMessage(int codeMessage) {
        this.codeMessage = codeMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}
