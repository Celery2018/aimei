package com.bizconf.net;

/**
 * Created by Byron on 2017/6/5.
 */
public class APICode {

	//更新已会议列表
	public static  final String meetingListUrl="getScheduledConfListBySiteSign";
	//更新已会议列表
	public static  final String openMeetingListUrl="getLivingConfListBySiteSign";
	//更新已会议列表
	public static  final String finishMeetingUrl="getFinishedConfListBySiteSign";


    //预约会议
	public static  final String createMeeting="confReservation";
	//获取会议信息
	public static final String getMeetingInfo="getConfDetailByConfId";
	//修改会议
	public static final String meetingEdit="confModify2";
	//删除会议
	public static final String deleteMeeting="cancelConf";
	//获取会议室方数
	public static final String getRoomSize="getRoomPartiesBySiteSign";

	//接入号地址
	public static final String ACCESSADRESSTest="https://api.bizvideo.cn/user/conf/callInPhoneList";
	public static final String ACCESSADRESSFORMAL="https://api.bizvideo.cn/user/conf/callInPhoneList";
}
