package com.aimei.service.common.memberService;

import com.aimei.domain.entity.Client;
import com.aimei.domain.entity.Member;

import java.util.List;

/**
 * Created by peter on 25/10/2017.
 */

public interface MemberService {
    List<Member> getMemberList(String memberId);
    boolean addMember(Member  member);
    boolean updateMember(Member  member);
    boolean deleteMember(String memberId);
    List<Member> getMemberByName(String memberName);
}
