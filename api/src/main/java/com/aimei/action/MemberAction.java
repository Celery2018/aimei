package com.aimei.action;


import com.aimei.dao.domain.dto.Result;
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
import javax.xml.ws.Response;
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
    public @ResponseBody Result listUser(String memberId) {
        List<Member> list=memberService.getMemberList(memberId);
        return new Result(true,list);
    }

    /**
     * 添加一个新会员
     * @param member
     * @return
     */
    @RequestMapping(value="/addMember",method = {RequestMethod.POST})
    public @ResponseBody
    Result addMember(@RequestBody Member member) {
        //先检查该用户名是否已被占用
        Result result=null;
        try {
            List<Member> members=memberService.getMemberByName(member.getName());
            if(members!=null&&members.size()>0)
                result=new Result(false,"该用户已存在");
            else {
                boolean add=memberService.addMember(member);
                result=new Result(add,add?"注册成功":"注册失败");
            }
        }catch (Exception e){
                result=new Result(false,"注册失败");
        }
        return result;
    }


    /**
     * 更新一个会员的信息
     * @param member
     * @return
     */
    @RequestMapping(value="/updateMember",method = {RequestMethod.POST})
    public @ResponseBody Result updateMember(@RequestBody Member member) {
        Result result=null;
        try {
            boolean add=memberService.updateMember(member);
            result=new Result(add,add?"更新成功！":"更新失败");
        }catch (Exception e){
            result=new Result(false,"更新失败");
        }

        return result;
    }

    /**
     * 删除一个会员的数据
     * @param memberId
     * @return
     */
    @RequestMapping(value="/deleteMember",method = {RequestMethod.GET})
    public @ResponseBody Result deleteMember( String memberId) {
        Result result=null;
        try {
            boolean add=memberService.deleteMember(memberId);
            result=new Result(add,add?"删除成功！":"删除失败");
        }catch (Exception e){
            result=new Result(false,"删除失败");
        }
        return result;
    }

}
