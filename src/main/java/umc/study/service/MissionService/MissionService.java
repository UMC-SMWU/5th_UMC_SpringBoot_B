package umc.study.service.MissionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import umc.study.converter.MissionConverter;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.domain.mapping.MemberMission;
import umc.study.repository.MemberRepository;
import umc.study.repository.MissionRepository;
import umc.study.repository.StoreRepository;
import umc.study.web.dto.MissionDTO;
import umc.study.web.dto.MissionMemberDTO;

import javax.transaction.Transactional;

@Service
public class MissionService {

    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;

    private final MissionConverter missionConverter;

    @Autowired
    public MissionService(StoreRepository storeRepository, MissionRepository missionRepository, MemberRepository memberRepository, MissionConverter missionConverter) {
        this.storeRepository = storeRepository;
        this.missionRepository = missionRepository;
        this.memberRepository = memberRepository;
        this.missionConverter = missionConverter;
    }


    public MissionDTO addMission(Long storeId, MissionDTO missionDto) {
        Store store = storeRepository.findById(storeId).orElseThrow(() -> new RuntimeException("Store not found"));
        Mission mission = missionConverter.convertToEntity(missionDto);
        mission.updateStore(store);
        missionRepository.save(mission);
        return missionConverter.convertToDto(mission);
    }

    @Transactional
    public void addMissionToMember(MissionMemberDTO missionMemberDto) {
        Member member = memberRepository.findById(missionMemberDto.getMemberId()).orElseThrow(() -> new RuntimeException("Member not found"));
        Mission mission = missionRepository.findById(missionMemberDto.getMissionId()).orElseThrow(() -> new RuntimeException("Mission not found"));

        if (member.getMemberMissionList().stream().anyMatch(memberMission -> memberMission.getMission().equals(mission))) {
            throw new RuntimeException("Mission is already in progress");
        }

        MemberMission memberMission = new MemberMission(member, mission);
        member.getMemberMissionList().add(memberMission);
    }

}
