package com.aimei.action;

import com.aimei.dao.domain.dto.Result;
import com.aimei.domain.entity.Member;
import com.aimei.service.common.memberService.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
/**
 * 登录接口类
 */

@Controller
@RequestMapping("/auth")
public class LoginAction {
    @Resource
    private MemberService memberService;

    /**
     * 登录操作（此系统未加入session管理机制）
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody Member member) {

        Result execution = null;
        try {
            List<Member> memberList = memberService.getMemberByName(member.getName());
            if (memberList.size() < 1)
                execution = new Result(false, "用户名不存在！");
            else if (memberList.get(0).getPassword().equals(member.getPassword()))
                execution = new Result(true, memberList.get(0));
            else
                execution = new Result(true, "密码错误！");
        } catch (Exception e) {
            execution = new Result(false, "登录失败！");
        }
        return execution;
    }


}
