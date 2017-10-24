package com.spring;

import com.bizconf.domain.Meeting;
import com.bizconf.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.WebMethod;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by peter on 24/10/2017.
 */
@Controller
@RequestMapping("/test")
public class TestAction {


    @RequestMapping(value="/hello",method = {RequestMethod.POST })
    public @ResponseBody Meeting listUser(HttpServletRequest request,@RequestBody Meeting meeting) {
        return meeting;
    }
}
