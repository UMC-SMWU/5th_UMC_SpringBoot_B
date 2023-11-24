package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MissionDTO {

    private Integer reward;
    private LocalDate deadline;
    private String missionSpec;

    public void updateReward(Integer reward) {
        this.reward = reward;
    }

    public void updateDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public void updateMissionSpec(String missionSpec) {
        this.missionSpec = missionSpec;
    }
}
