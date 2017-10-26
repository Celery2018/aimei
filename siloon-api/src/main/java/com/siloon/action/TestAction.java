package com.siloon.action;



import com.siloon.domain.entity.Client;
import com.siloon.service.common.client.ClientService;
import com.siloon.util.LogHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import org.slf4j.Logger;

/**
 * Created by peter on 24/10/2017.
 */
@Controller
@RequestMapping("/test")
public class TestAction {
    private static final Logger logger= LogHelper.log_consoleFile;

    @Resource
    private ClientService clientService;


    @RequestMapping(value="/hello",method = {RequestMethod.POST })
    public @ResponseBody String listUser(HttpServletRequest request,@RequestBody String meeting) {
        return "Hello";
    }

    @RequestMapping(value = "/query",method = {RequestMethod.POST})
    public @ResponseBody
    Client query(HttpServletRequest request, @RequestBody String clientID){
        return clientService.queryById(clientID);
    }

    @RequestMapping(value = "/getAll",method = {RequestMethod.GET})
    public @ResponseBody
    List<Client> query(HttpServletRequest request){
        return clientService.queryAll();
    }
}
