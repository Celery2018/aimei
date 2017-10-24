package com.bizconf.meeting.impl;

import com.bizconf.AbstractBaseDao;
import com.bizconf.domain.Meeting;
import com.bizconf.domain.User;
import com.bizconf.meeting.MeetingDao;
import com.bizconf.meeting.UserDao;
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
public class UserDaoImpl extends AbstractBaseDao implements UserDao {

    private static final String NAMESPACEMEETING = "User.";
    private static final org.slf4j.Logger logger = LogHelper.log_action;






    @Override
    public User add(User user) {
        logger.debug("dataBase新增User"+JsonUtils.toJson(user));
        int id = ((Integer)this.insert(NAMESPACEMEETING + "ADD", user)).intValue();
        user.setId(id);
        return user;
    }

    @Override
    public Integer update(User user) {
        logger.debug("dataBase更新User"+ JsonUtils.toJson(user));
        return this.update(NAMESPACEMEETING + "UPDATE", user);
    }

    @Override
    public boolean delete(User user) {
        this.delete(NAMESPACEMEETING+"DELETE_BY_USERID",user);
        return true;
    }

    @Override
    public List<User> queryByUserId(String userId) {
        User user=new User();
       user.setUserId(String.valueOf(userId));
        return this.queryForList(NAMESPACEMEETING + "FIND_BY_USERID",user);
    }
}
