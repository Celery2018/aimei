package com.aimei.dao.member;


import com.aimei.domain.entity.Member;

import java.util.List;

public interface MemberDao {
    List<Member> getMemberList(String memberId);
    boolean addMember(Member member);
    boolean updateMember(Member member);
    boolean deleteMember(String memberId);
    List<Member> getMemberByName(String memberName);
}
