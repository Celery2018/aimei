package com.bizconf.domain;

/**
 * Created by peter on 9/6/2017.
 */
public class MeetingUser {
    private int id;
    private String userId;//userID
    private String confId;//会议ID
    private int nature;//1主持人，2参会人

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getConfId() {
        return confId;
    }

    public void setConfId(String confId) {
        this.confId = confId;
    }

    public int getNature() {
        return nature;
    }

    public void setNature(int nature) {
        this.nature = nature;
    }
}
