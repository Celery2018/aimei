package com.spring;

import com.bizconf.domain.entity.Client;
import com.bizconf.service.common.client.ClientService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by peter on 24/10/2017.
 */
@Controller
@RequestMapping("/test")
public class TestAction {

    @Resource
    private ClientService clientService;


    @RequestMapping(value="/hello",method = {RequestMethod.POST })
    public @ResponseBody String listUser(HttpServletRequest request,@RequestBody String meeting) {
        return "Hello";
    }

    @RequestMapping(value = "/query",method = {RequestMethod.POST})
    public @ResponseBody Client query(HttpServletRequest request,@RequestBody String clientID){
        return clientService.queryById(clientID);
    }

    @RequestMapping(value = "/getAll",method = {RequestMethod.GET})
    public @ResponseBody
    List<Client> query(HttpServletRequest request){
        return clientService.queryAll();
    }
}
