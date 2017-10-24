package com.bizconf.meeting.impl;

import com.bizconf.AbstractBaseDao;
import com.bizconf.domain.Meeting;
import com.bizconf.domain.MeetingUser;
import com.bizconf.domain.User;
import com.bizconf.meeting.MeetingDao;
import com.bizconf.meeting.MeetingUserDao;
import com.bizconf.utils.JsonUtils;
import common.util.LogHelper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User: Byron
 * Date: 2017/2/9
 * Time: 16:28
 */
@Component
public class MeetingUserDaoImpl extends AbstractBaseDao implements MeetingUserDao {

    private static final String NAMESPACEMEETING = "MEETINGUSER.";
    private static final org.slf4j.Logger logger = LogHelper.log_action;




    @Override
    public MeetingUser add(MeetingUser meetingUser) {
        logger.debug("dataBase新增Vehicle" + JsonUtils.toJson(meetingUser));
        int id = ((Integer) this.insert(NAMESPACEMEETING + "ADD", meetingUser)).intValue();
        meetingUser.setId(id);
        return meetingUser;
    }

    @Override
    public boolean delete(MeetingUser meetingUser) {
        logger.debug("dataBase更新Vehicle" + JsonUtils.toJson(meetingUser));
        this.update(NAMESPACEMEETING + "DELETE_BY_CONFID", meetingUser);
        return true;
    }

    @Override
    public List<Meeting> queryMeeting(String userId) {
        MeetingUser meetingUser = new MeetingUser();
        meetingUser.setUserId(userId);
        return this.queryForList(NAMESPACEMEETING + "FIND_BY_USERID", meetingUser);
    }

    @Override
    public List<User> queryUser(int confId) {
        MeetingUser meetingUser = new MeetingUser();
        meetingUser.setConfId(String.valueOf(confId));
        return this.queryForList(NAMESPACEMEETING + "FIND_BY_CONFID", meetingUser);
    }

    @Override
    public List<MeetingUser> queryMeetingUser(int confId, String userId) {
        MeetingUser meetingUser = new MeetingUser();
        meetingUser.setConfId(String.valueOf(confId));
        meetingUser.setUserId(userId);
        return this.queryForList(NAMESPACEMEETING + "FIND_MEETINGUSER", meetingUser);
    }

    @Override
    public List<MeetingUser> queryByConfId(int confId) {
        MeetingUser meetingUser = new MeetingUser();
        meetingUser.setConfId(String.valueOf(confId));
        return this.queryForList(NAMESPACEMEETING + "FIND_MEETINGUSERS", meetingUser);
    }
}
