package com.aimei.service.common.memberService.impl;

import com.aimei.dao.member.MemberDao;
import com.aimei.domain.entity.Member;
import com.aimei.service.common.memberService.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by peter on 25/10/2017.
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;


    @Override
    public List<com.aimei.domain.entity.Member> getMemberList(String memberId) {
        return memberDao.getMemberList(memberId);
    }

    @Override
    public boolean addMember(com.aimei.domain.entity.Member member) {
        return memberDao.addMember(member);
    }

    @Override
    public boolean updateMember(com.aimei.domain.entity.Member member) {
        return memberDao.updateMember(member);
    }

    @Override
    public boolean deleteMember(String memberId) {
        return memberDao.deleteMember(memberId);
    }

    @Override
    public List<Member> getMemberByName(String memberName) {
        return memberDao.getMemberByName(memberName);
    }


}
