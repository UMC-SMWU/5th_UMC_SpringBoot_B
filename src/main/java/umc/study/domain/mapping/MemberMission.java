package umc.study.domain.mapping;

import lombok.*;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.enums.MissionStatus;

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

    @Enumerated(EnumType.STRING)
    private MissionStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    public MemberMission(Member member, Mission mission) {
        this.member=member;
        this.mission=mission;
    }

    public void updateId(Long id) {
        this.id = id;
    }

    public void updateStatus(MissionStatus status) {
        this.status = status;
    }

    public void updateMember(Member member) {
        this.member = member;
    }

    public void updateMission(Mission mission) {
        this.mission = mission;
    }
}
