package common;

/**
 * Created by peter on 8/6/2017.
 */
public class StatusCode {
    //创建会议
    public static final int CREATE_MEETING=430;
    //修改会议
    public static final int EDIT_MEETING=431;
    //获取会议信息
    public static final int GET_MEETING_INFO=432;
    //删除会议
    public static final int DELETE_MEETING=433;
    //获取用户会议列表
    public static final int GET_USER_MEETINGS=434;
    //获取会议室方数列表
    public static final int GET_ROOM_SIZE=435;
    //获取邀请信息
    public static final int GET_INVATATION_INFO=436;
    //创建会议推送
    public static final int PUSH_CREATE=437;
    //会议更改推送
    public static final int PUSH_EDIT=438;
    //会议取消推送
    public static final int PUSH_CANCEL=439;
    //会议开始通知
    public static final int PUSH_START=440;
    //会议创建成功
    public static final int PUSH_CREATESUCCESS=441;


    /**
     * 推送消息配置
     */
    //测试
    public static final String clientIdMainTest="162046";
    public static final String clientIdInternalTest="104606038";

    //正式
    public static final String clientIdMainFormal="162044";
    public static final String clientIdInternalFormal="104604570";
}
