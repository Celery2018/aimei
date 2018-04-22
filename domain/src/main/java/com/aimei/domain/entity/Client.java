package com.aimei.domain.entity;

/**
 * Created by peter on 25/10/2017.
 */
public class Client {
    private String clientID;
    private String clientName;
    private String clientManger;

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientManger() {
        return clientManger;
    }

    public void setClientManger(String clientManger) {
        this.clientManger = clientManger;
    }
}
