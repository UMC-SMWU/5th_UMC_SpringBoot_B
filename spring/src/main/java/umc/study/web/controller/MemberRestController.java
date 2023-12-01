package umc.study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MemberConverter;
import umc.study.domain.mapping.MemberMission;
import umc.study.domain.member;
import umc.study.service.MemberService.MemberCommandService;
import umc.study.web.dto.MemberRequestDTO;
import umc.study.web.dto.MemberResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @PostMapping("/missions/{missionId}")
    public ApiResponse<MemberResponseDTO.challengeMissionResultDTO> challengeMission(@PathVariable(name = "missionId") Long missionId,
                                                                                           @RequestParam(name = "memberId") Long memberId) {
        MemberMission memberMission = memberCommandService.challengeMission(memberId, missionId);
        return ApiResponse.onSuccess(MemberConverter.toChallengeMissionResultDTO(memberMission));
    }
}