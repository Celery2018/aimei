package com.bizconf.meeting;

import com.bizconf.domain.Meeting;

import java.util.List;

/**
 * User: Byron
 * Date: 2017/2/9
 * Time: 16:15
 */
public interface MeetingDao {

     Meeting add(Meeting meeting);

     Integer update(Meeting meeting);

     boolean delete(Meeting meeting);

     List<Meeting> queryByMeetingID(int confId);

     List<Meeting> queryAll();

}
