package umc.study.domain;

import lombok.*;
import umc.study.domain.common.BaseEntity;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    private float point;

    private String text;

    @Column(length = 100)
    private String photo;

    private String reply;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private store store;

    public void setMember(member member){
        if(this.member != null)
            member.getMemberReviewList().remove(this);
        this.member = member;
        member.getMemberReviewList().add(this);
    }

    public void setStore(store store){
        if(this.store != null)
            store.getStoreReviewList().remove(this);
        this.store = store;
        store.getStoreReviewList().add(this);
    }
}
