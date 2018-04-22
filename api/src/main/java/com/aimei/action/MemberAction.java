package com.aimei.action;


import com.aimei.domain.entity.Client;
import com.aimei.service.common.client.ClientService;
import com.aimei.util.LogHelper;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by peter on 24/10/2017.
 */
@Controller
@RequestMapping("/member")
public class MemberAction {
    private static final Logger logger= LogHelper.log_consoleFile;

    @Resource
    private ClientService clientService;


    @RequestMapping(value="/hello",method = {RequestMethod.GET})
    public String listUser() {
        return "Hello";
    }


}
