package com.umc.demo.web.controller;

import com.umc.demo.apiPayload.ApiResponse;
import com.umc.demo.converter.MemberConverter;
import com.umc.demo.domain.Member;
import com.umc.demo.service.MemberService.MemberCommandService;
import com.umc.demo.web.dto.MemberRequestDTO;
import com.umc.demo.web.dto.MemberResponseDTO;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }
}
