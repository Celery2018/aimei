package com.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by peter on 24/10/2017.
 */
@Controller
@RequestMapping("/test")
public class TestAction {


    @RequestMapping(value="/hello",method = {RequestMethod.POST })
    public @ResponseBody String listUser(HttpServletRequest request,@RequestBody String meeting) {
        return "Hello";
    }
}
