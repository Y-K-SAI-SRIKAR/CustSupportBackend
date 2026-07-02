package com.nexvitalssupport.dto.response;

public class QueryResponse {

    private String reply;
    private String sessionId;

    public QueryResponse() {
    }

    public QueryResponse(String reply) {
        this.reply = reply;
    }

    public QueryResponse(String reply, String sessionId) {
        this.reply = reply;
        this.sessionId = sessionId;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}