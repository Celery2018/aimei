package com.bizconf.meeting.impl;

import com.bizconf.domain.Meeting;
import com.bizconf.domain.User;

import com.bizconf.meeting.UserService;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Byron on 2017/6/6.
 */
@Component
public class UserImpService implements UserService {


    @Override
    public User add(User user) {
        return null;
    }

    @Override
    public Integer update(User User) {
        return null;
    }

    @Override
    public boolean delete(User User) {
        return false;
    }

    @Override
    public List<User> queryByUserId(String userId) {
        return null;
    }
}
