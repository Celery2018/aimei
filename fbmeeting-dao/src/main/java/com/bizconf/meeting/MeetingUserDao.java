package com.bizconf.meeting;

import com.bizconf.domain.Meeting;
import com.bizconf.domain.MeetingUser;
import com.bizconf.domain.User;

import java.util.List;

/**
 * User: Byron
 * Date: 2017/2/9
 * Time: 16:15
 */
public interface MeetingUserDao {

     MeetingUser add(MeetingUser meetingUser);

     boolean delete(MeetingUser meetingUser);

     List<Meeting> queryMeeting(String userId);

     List<User> queryUser(int confId);

     List<MeetingUser> queryMeetingUser(int confId,String userId);

     List<MeetingUser> queryByConfId(int confId);

}
