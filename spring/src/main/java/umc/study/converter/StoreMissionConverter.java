package umc.study.converter;

import umc.study.domain.Mission;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;

public class StoreMissionConverter {
    public static Mission toMission(StoreRequestDTO.MissionDto request){
        return Mission.builder()
                .point(request.getPoint())
                .text(request.getText())
                .build();
    }

    public static StoreResponseDTO.newMissionResultDto toNewMissionResultDto(Mission mission){
        return StoreResponseDTO.newMissionResultDto.builder()
                .missionId(mission.getMissionId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
