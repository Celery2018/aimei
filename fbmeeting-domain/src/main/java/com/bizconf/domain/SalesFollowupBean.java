package com.bizconf.domain;

import java.util.List;

/**
 * Created by peter on 20/6/2017.
 */
public class SalesFollowupBean {
    private String[] customer_email;//发送邮件的联系人列表
    private  String task_content;//主题
    private  String task_msg;//正文
    private  String task_fulltime;//时间
    private String id;
    private String sales_id;

    public String[] getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String[] customer_email) {
        this.customer_email = customer_email;
    }

    public String getTask_content() {
        return task_content;
    }

    public void setTask_content(String task_content) {
        this.task_content = task_content;
    }

    public String getTask_msg() {
        return task_msg;
    }

    public void setTask_msg(String task_msg) {
        this.task_msg = task_msg;
    }

    public String getTask_fulltime() {
        return task_fulltime;
    }

    public void setTask_fulltime(String task_fulltime) {
        this.task_fulltime = task_fulltime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSales_id() {
        return sales_id;
    }

    public void setSales_id(String sales_id) {
        this.sales_id = sales_id;
    }
}
