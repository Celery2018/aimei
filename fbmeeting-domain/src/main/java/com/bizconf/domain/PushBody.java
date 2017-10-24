package com.bizconf.domain;

import java.util.List;

/**
 * Created by cdxy_ on 2017/6/14.
 */
public class PushBody {
    private String title;
    private List<Key> form;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Key> getForm() {
        return form;
    }

    public void setForm(List<Key> form) {
        this.form = form;
    }
}
