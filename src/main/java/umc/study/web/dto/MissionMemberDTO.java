package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
public class MissionMemberDTO {
    private Long memberId;
    private Long missionId;

    public MissionMemberDTO(Long memberId, Long missionId) {
        this.memberId = memberId;
        this.missionId = missionId;
    }

    public void updateMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public void updateMissionId(Long missionId) {
        this.missionId = missionId;
    }
}
