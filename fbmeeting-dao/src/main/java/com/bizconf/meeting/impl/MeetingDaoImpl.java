package com.bizconf.meeting.impl;

import com.bizconf.AbstractBaseDao;
import com.bizconf.domain.Meeting;
import com.bizconf.domain.User;
import com.bizconf.meeting.MeetingDao;
import common.util.LogHelper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User: Byron
 * Date: 2017/2/9
 * Time: 16:28
 */
@Component
public class MeetingDaoImpl extends AbstractBaseDao implements MeetingDao {

    private static final String NAMESPACEMEETING = "MEETING.";
    private static final org.slf4j.Logger logger = LogHelper.log_action;


    @Override
    public Meeting add(Meeting meeting) {
        logger.debug("dataBase新增User"+JsonUtils.toJson(meeting));
        int id = ((Integer)this.insert(NAMESPACEMEETING + "ADD",meeting)).intValue();
        meeting.setId(id);
        return meeting;
    }

    @Override
    public Integer update(Meeting meeting) {
         logger.debug("dataBase更新User"+ JsonUtils.toJson(meeting));
        return this.update(NAMESPACEMEETING + "UPDATE", meeting);
    }

    @Override
    public boolean delete(Meeting meeting) {
        this.delete(NAMESPACEMEETING+"DELETE_BY_CONFID",meeting);
        return true;
    }

    @Override
    public List<Meeting> queryByMeetingID(int confId) {
        Meeting meeting=new Meeting();
        meeting.setConfId(confId);
        return this.queryForList(NAMESPACEMEETING + "FIND_BY_CONFID",meeting);
    }

    @Override
    public List<Meeting> queryAll() {
        return this.queryForList(NAMESPACEMEETING + "FIND_ALL");
    }
}
