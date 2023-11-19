package umc.study.domain;

import lombok.*;
import umc.study.domain.common.BaseEntity;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class alarm extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long alarmId;

    @Column(length = 20)
    private String dataType;

    private boolean isConfirmed;

    @Column(length = 30)
    private String title;

    private String body;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private member member;
}
