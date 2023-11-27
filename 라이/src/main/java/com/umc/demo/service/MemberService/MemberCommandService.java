package com.umc.demo.service.MemberService;

import com.umc.demo.domain.Member;
import com.umc.demo.web.dto.MemberRequestDTO;

public interface MemberCommandService {

    Member joinMember(MemberRequestDTO.JoinDto request);
}
