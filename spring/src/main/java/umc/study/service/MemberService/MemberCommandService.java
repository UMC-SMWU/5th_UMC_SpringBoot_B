package umc.study.service.MemberService;

import umc.study.domain.mapping.MemberMission;
import umc.study.domain.member;
import umc.study.web.dto.MemberRequestDTO;

public interface MemberCommandService {
    member joinMember(MemberRequestDTO.JoinDto request);
    MemberMission challengeMission(Long memberId, Long missionId);
}
