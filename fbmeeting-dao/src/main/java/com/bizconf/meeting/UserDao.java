package com.bizconf.meeting;

import com.bizconf.domain.Meeting;
import com.bizconf.domain.User;

import java.util.List;

/**
 * User: Byron
 * Date: 2017/2/9
 * Time: 16:15
 */
public interface UserDao {

     User add(User user);

     Integer update(User User);

     boolean delete(User User);

     List<User> queryByUserId(String userId);

}
