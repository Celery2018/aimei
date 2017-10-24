package common;

import com.bizconf.net.APICode;

/**
 * Created by Byron on 2017/2/24.
 */
public class SystemConfig {


	public static int businessTimeOut = 5000;


	/**
	 * 会畅配置
	 */
//	https://api.bizvideo.cn/openapi/v1/confReservation
	//public static final String BIZCONF_ROOT_URl = "https://go.bizvideo.cn/openapi/v1/";
	public static final String BIZCONF_ROOT_URl = "https://api.bizvideo.cn/openapi/v1/";
	public static final String SYMBOL_QUESTION="?";
	public static final String SITE_SIGN="fosun";
	public static final String API_KEY="fa78769f81f5d6fcd4329590222c503e";
	public static final String SYMBOL_BE_EQUAL_TO="=";
	public static final String ENG_LANGUAGE="en";
	public static final String CN_LANGUAGE="cn";

//	//入会页面链接
//	public static final String joinUrl="http://ouat.fosun.com/fbmeeting/dist/#/startMeeting";
//	//取消会议页面链接
//	public static final String cancelUrl="http://ouat.fosun.com/fbmeeting/dist/#/meetingCancel";
//	//获取用户邮箱地址
//	public static final String getUserEmail="http://ouat.fosun.com/uuc/fosun/out/outwork/getFosunEmployeesDetails";

	//获取用户邮箱地址
	public static final String getUserEmail="http://o.fosun.com/uuc/fosun/out/outwork/getFosunEmployeesDetails";

	//public static final String getEngName="http://ouat.fosun.com/uuc/fosun/out/outwork/queryFosunUserInfo";
	public static final String getEngName="http://o.fosun.com/uuc/fosun/out/outwork/queryFosunUserInfo";
	//入会页面链接
	public static final String joinUrl="https://oapi.fosun.com/fbmeeting/dist/#/startMeeting";
	//取消会议页面链接
	public static final String cancelUrl="https://oapi.fosun.com/fbmeeting/dist/#/meetingCancel";


    //推送消息地址
	public static final String PUSH_MSG_URL_TEST="https://oapiuat.fosun.com:8445/api/message/sendOaByUserId";
	public static final String PUSH_MSG_URL_MAIL="https://oapi.fosun.com/api/message/sendOaByUserId";


	public static final long FIVETTENMINUTE=900000;
	public static final long TIMESTEAMPTIMEOUT=1000*10;

	 //推送消息使用测试配置or正式配置
	public static final boolean PUSH_TEST=false;
	//是否开启token验证
	public static final boolean USETOKEN=false;


	//发送邮件配置

	public static final String SMTP_HOST="smtp.fosun.com";
	public static final String SMTP_PORT="25";
	public static final String ADDRESS="video_conf@fosun.com";
	public static final String FROM_USER="video_conf@fosun.com";
	public static final String USER_PASSWORD="Fosun@0901!";

}
