package com.umc.demo.service.MemberService;

import com.umc.demo.domain.Member;
import java.util.Optional;

public interface MemberQueryService {

    Optional<Member> findMember(Long id);
}
