package com.pepo.demo.backend.dto;

import java.io.Serializable;

public class EmailRequestDTO implements Serializable {

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    private String to;
    private String subject;
    private String body;
}
