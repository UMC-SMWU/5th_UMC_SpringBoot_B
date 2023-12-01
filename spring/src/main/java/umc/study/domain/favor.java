package umc.study.domain;

import lombok.*;
import umc.study.domain.common.BaseEntity;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class favor extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long favorId;

    private int korea;

    private int japan;

    private int china;

    private int western;

    private int chicken;

    private int snack;

    private int roasted;

    private int box;

    private int night;

    private int fast;

    private int dessert;

    private int asian;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private member member;
}
