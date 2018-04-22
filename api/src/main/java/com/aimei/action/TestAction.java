package com.aimei.action;


import com.aimei.domain.entity.Client;
import com.aimei.domain.entity.Member;
import com.aimei.service.common.client.ClientService;
import com.aimei.service.common.memberService.MemberService;
import com.aimei.util.LogHelper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/test")
public class TestAction {
    private static final Logger logger= LogHelper.log_consoleFile;

    @Resource
    private ClientService clientService;

    @Autowired
    private MemberService memberService;


    @RequestMapping(value="/getUserList",method = {RequestMethod.GET})
    public @ResponseBody List<Member> listUser(String memberId) {
        List<Member> list=memberService.getMemberList(memberId);
        return list;
    }

    @RequestMapping(value="/addMember",method = {RequestMethod.POST})
    public @ResponseBody String addMember(@RequestBody Member member) {
       boolean add=memberService.addMember(member);
        return String.valueOf(add);
    }

    @RequestMapping(value="/updateMember",method = {RequestMethod.POST})
    public @ResponseBody String updateMember(@RequestBody Member member) {
        boolean add=memberService.updateMember(member);
        return String.valueOf(add);
    }

    @RequestMapping(value="/deleteMember",method = {RequestMethod.GET})
    public @ResponseBody String deleteMember( String memberId) {
        boolean add=memberService.deleteMember(memberId);
        return String.valueOf(add);
    }
//    @RequestMapping(value = "/query",method = {RequestMethod.POST})
//    public @ResponseBody
//    Client query(HttpServletRequest request, @RequestBody String clientID){
//
//    }
//
//    @RequestMapping(value = "/getAll",method = {RequestMethod.GET})
//    public @ResponseBody
//
}
