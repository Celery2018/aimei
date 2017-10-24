package com.bizconf.domain;

import java.util.Date;
import java.util.List;

/**
 * Created by peter on 6/6/2017.
 */
public class Meeting {
    private int id;
    private String protocolHostStartUrl; //协议启会地址
    private String hostStartUrl;//主持人启会地址
    private int confStatus;//会议状态
    private String confPassword;//会议密码
    private int optionJbh;//是否允许先于支持人入会
    private String startTime;//会议开始时间
    private int optionVideoParticipants;//会议与会人视频选项设置，0 关闭视频 1 开启视频
    private int confId;//会畅会议ID
    private int duration;//会议时长
    private String protocolJoinUrl;//协议入会地址
    private String userId;//创建会议用户id
    private String userName;//用户名
    private String confName;//会议名称
    private int confParties;//会议方数
    private String joinUrl;//入会地址
    private int confDelFlag;//会议删除状态 0,无效数据、1,正常使用、2,已删除
    private int optionVideoHost;//会议主持人视频选项设置，0 关闭视频 1 开启视频
    private String confNumber;//会议号码
    private int roomId;//会议室ID
    private List<User> userList;
    private String timeZone;//时区
    private String remark;//备注
    private String hostUserId;//主持人ID
    private String fusonJoinUrl;//fuson入会地址
    private String infoZH;
    private String infoEN;
    private String accessAddress;
    private String actualTime;//会议实际开始时间
    private String token;
    private String timeStamp;
    private String siteSign;
    private String h323pwd;//硬件入会密码
    private String rcIps;//硬件入会地址
    private int isPush;//是否进行过消息推送
    private String language;//当前前端语言

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProtocolHostStartUrl() {
        return protocolHostStartUrl;
    }

    public void setProtocolHostStartUrl(String protocolHostStartUrl) {
        this.protocolHostStartUrl = protocolHostStartUrl;
    }

    public String getHostStartUrl() {
        return hostStartUrl;
    }

    public void setHostStartUrl(String hostStartUrl) {
        this.hostStartUrl = hostStartUrl;
    }

    public int getConfStatus() {
        return confStatus;
    }

    public void setConfStatus(int confStatus) {
        this.confStatus = confStatus;
    }

    public String getConfPassword() {
        return confPassword;
    }

    public void setConfPassword(String confPassword) {
        this.confPassword = confPassword;
    }

    public int getOptionJbh() {
        return optionJbh;
    }

    public void setOptionJbh(int optionJbh) {
        this.optionJbh = optionJbh;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public int getOptionVideoParticipants() {
        return optionVideoParticipants;
    }

    public void setOptionVideoParticipants(int optionVideoParticipants) {
        this.optionVideoParticipants = optionVideoParticipants;
    }

    public int getConfId() {
        return confId;
    }

    public void setConfId(int confId) {
        this.confId = confId;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getProtocolJoinUrl() {
        return protocolJoinUrl;
    }

    public void setProtocolJoinUrl(String protocolJoinUrl) {
        this.protocolJoinUrl = protocolJoinUrl;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getConfName() {
        return confName;
    }

    public void setConfName(String confName) {
        this.confName = confName;
    }

    public int getConfParties() {
        return confParties;
    }

    public void setConfParties(int confParties) {
        this.confParties = confParties;
    }

    public String getJoinUrl() {
        return joinUrl;
    }

    public void setJoinUrl(String joinUrl) {
        this.joinUrl = joinUrl;
    }

    public int getConfDelFlag() {
        return confDelFlag;
    }

    public void setConfDelFlag(int confDelFlag) {
        this.confDelFlag = confDelFlag;
    }

    public int getOptionVideoHost() {
        return optionVideoHost;
    }

    public void setOptionVideoHost(int optionVideoHost) {
        this.optionVideoHost = optionVideoHost;
    }

    public String getConfNumber() {
        return confNumber;
    }

    public void setConfNumber(String confNumber) {
        this.confNumber = confNumber;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getSiteSign() {
        return siteSign;
    }

    public void setSiteSign(String siteSign) {
        this.siteSign = siteSign;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getHostUserId() {
        return hostUserId;
    }

    public void setHostUserId(String hostUserId) {
        this.hostUserId = hostUserId;
    }

    public String getFusonJoinUrl() {
        return fusonJoinUrl;
    }

    public void setFusonJoinUrl(String fusonJoinUrl) {
        this.fusonJoinUrl = fusonJoinUrl;
    }

    public String getInfoZH() {
        return infoZH;
    }

    public void setInfoZH(String infoZH) {
        this.infoZH = infoZH;
    }

    public String getInfoEN() {
        return infoEN;
    }

    public void setInfoEN(String infoEN) {
        this.infoEN = infoEN;
    }

    public String getAccessAddress() {
        return accessAddress;
    }

    public void setAccessAddress(String accessAddress) {
        this.accessAddress = accessAddress;
    }

    public String getActualTime() {
        return actualTime;
    }

    public void setActualTime(String actualTime) {
        this.actualTime = actualTime;
    }

    public String getH323pwd() {
        return h323pwd;
    }

    public void setH323pwd(String h323pwd) {
        this.h323pwd = h323pwd;
    }

    public String getRcIps() {
        return rcIps;
    }

    public void setRcIps(String rcIps) {
        this.rcIps = rcIps;
    }

    public int getIsPush() {
        return isPush;
    }

    public void setIsPush(int isPush) {
        this.isPush = isPush;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
