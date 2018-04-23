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
 * 会员操作类
 */
@Controller
@RequestMapping("/member")
public class MemberAction {
    private static final Logger logger= LogHelper.log_consoleFile;


    @Autowired
    private MemberService memberService;


    /**
     * 获取会员列表（传入会员ID时获取某一个会员信息，未传入时获取所有会员的信息）
     * @param memberId
     * @return
     */
    @RequestMapping(value="/getUserList",method = {RequestMethod.GET})
    public @ResponseBody List<Member> listUser(String memberId) {
        List<Member> list=memberService.getMemberList(memberId);
        return list;
    }

    /**
     * 添加一个新会员
     * @param member
     * @return
     */
    @RequestMapping(value="/addMember",method = {RequestMethod.POST})
    public @ResponseBody String addMember(@RequestBody Member member) {
       boolean add=memberService.addMember(member);
        return String.valueOf(add);
    }


    /**
     * 更新一个会员的信息
     * @param member
     * @return
     */
    @RequestMapping(value="/updateMember",method = {RequestMethod.POST})
    public @ResponseBody String updateMember(@RequestBody Member member) {
        boolean add=memberService.updateMember(member);
        return String.valueOf(add);
    }

    /**
     * 删除一个会员的数据
     * @param memberId
     * @return
     */
    @RequestMapping(value="/deleteMember",method = {RequestMethod.GET})
    public @ResponseBody String deleteMember( String memberId) {
        boolean add=memberService.deleteMember(memberId);
        return String.valueOf(add);
    }

}
