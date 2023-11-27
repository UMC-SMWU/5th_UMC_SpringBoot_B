package com.umc.demo.service.MemberService;

import com.umc.demo.domain.Member;
import com.umc.demo.domain.mapping.MemberMission;
import com.umc.demo.repository.MemberMissionRepository;
import com.umc.demo.repository.MemberRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService{

    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public Optional<Member> findMember(Long id) {
        return memberRepository.findById(id);
    }

    @Override
    public Optional<MemberMission> findMemberMission(Long id) {
        return memberMissionRepository.findById(id);
    }
}
