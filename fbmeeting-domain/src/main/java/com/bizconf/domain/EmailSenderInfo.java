package com.bizconf.domain;

import java.util.List;

/**
 * Created by peter on 20/6/2017.
 */
public class EmailSenderInfo {
    private String mailServerPort;
    private String mailServerHost;
    private String transport;
    private String fromAddress;
    private String userName;
    private String password;
    private String content; //邮件正文
    private String subject; //主题
    private String toAddress;//邮件接收人
    private String[] toAddressArray;//多个邮件接收人
    private String fileName;//发送文件名称
    private String[] attachFileNames;
    private boolean doSend;

    public String getMailServerHost() {
        return mailServerHost;
    }

    public void setMailServerHost(String mailServerHost) {
        this.mailServerHost = mailServerHost;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }



    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String[] getToAddressArray() {
        return toAddressArray;
    }

    public void setToAddressArray(String[] toAddressArray) {
        this.toAddressArray = toAddressArray;
    }

    public String[] getAttachFileNames() {
        return attachFileNames;
    }

    public void setAttachFileNames(String[] attachFileNames) {
        this.attachFileNames = attachFileNames;
    }

    public boolean isDoSend() {
        return doSend;
    }

    public void setDoSend(boolean doSend) {
        this.doSend = doSend;
    }

    public String getMailServerPort() {
        return mailServerPort;
    }

    public void setMailServerPort(String mailServerPort) {
        this.mailServerPort = mailServerPort;
    }
}
