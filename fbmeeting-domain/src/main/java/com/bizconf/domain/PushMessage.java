package com.bizconf.domain;

/**
 * Created by cdxy_ on 2017/6/14.
 */
public class PushMessage {
    private String touser;
    private String toparty;
    private String msgtype;
    private String messageAgentId;
    private Oa oa;

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getToparty() {
        return toparty;
    }

    public void setToparty(String toparty) {
        this.toparty = toparty;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public String getMessageAgentId() {
        return messageAgentId;
    }

    public void setMessageAgentId(String messageAgentId) {
        this.messageAgentId = messageAgentId;
    }

    public Oa getOa() {
        return oa;
    }

    public void setOa(Oa oa) {
        this.oa = oa;
    }
}

