package umc.study.converter;

import org.springframework.stereotype.Component;
import umc.study.domain.Mission;
import umc.study.service.MissionService.MissionService;
import umc.study.web.dto.MissionDTO;

@Component
public class MissionConverter {

    public Mission convertToEntity(MissionDTO missionDto) {
        return Mission.builder()
                .reward(missionDto.getReward())
                .deadline(missionDto.getDeadline())
                .missionSpec(missionDto.getMissionSpec())
                .build();
    }

    public MissionDTO convertToDto(Mission mission) {
        MissionDTO missionDto = new MissionDTO();
        missionDto.updateReward(mission.getReward());
        missionDto.updateDeadline(mission.getDeadline());
        missionDto.updateMissionSpec(mission.getMissionSpec());
        return missionDto;
    }
}
