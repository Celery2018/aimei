package com.bizconf.domain;

import javax.net.ssl.SSLContext;

/**
 * Created by cdxy_ on 2017/6/14.
 */
public class Oa {
    private String message_url;
    private PushHead head;
    private PushBody body;

    public String getMessage_url() {
        return message_url;
    }

    public void setMessage_url(String message_url) {
        this.message_url = message_url;
    }

    public PushHead getHead() {
        return head;
    }

    public void setHead(PushHead head) {
        this.head = head;
    }

    public PushBody getBody() {
        return body;
    }

    public void setBody(PushBody body) {
        this.body = body;
    }
}
