package com.umc.demo.service.MemberService;

import com.umc.demo.domain.Member;
import com.umc.demo.domain.mapping.MemberMission;
import java.util.Optional;

public interface MemberQueryService {

    Optional<Member> findMember(Long id);
    Optional<MemberMission> findMemberMission(Long id);
}
