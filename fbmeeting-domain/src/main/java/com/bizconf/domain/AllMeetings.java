package com.bizconf.domain;

import java.util.List;

/**
 * Created by peter on 16/6/2017.
 */
public class AllMeetings {
    private int status;
    private List<Meeting> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Meeting> getData() {
        return data;
    }

    public void setData(List<Meeting> data) {
        this.data = data;
    }
}
