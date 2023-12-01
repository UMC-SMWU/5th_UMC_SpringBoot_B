package umc.study.domain.mapping;

import lombok.*;
import umc.study.domain.FoodCategory;
import umc.study.domain.Mission;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.member;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated
    private MissionStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    public void setMember(member member){
        if(this.member != null)
            member.getChallengingMissionList().remove(this);
        this.member = member;
        member.getChallengingMissionList().add(this);
    }

    public void setMission(Mission mission){
        if(this.mission != null)
            mission.getChallengingMissionList().remove(this);
        this.mission = mission;
        mission.getChallengingMissionList().add(this);
    }
}
