package umc.study.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;
import umc.study.domain.common.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "status = 'ACTIVE'")
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;
    private String username;
    private String password;

    @OneToMany(mappedBy = "member")
    private List<Survey> surveys;

    @OneToMany(mappedBy = "member")
    private List<MissionStatus> missionStatuses;

    @OneToMany(mappedBy = "member")
    private List<Review> reviews;

    @OneToMany(mappedBy = "member")
    private List<Point> points;

    @OneToMany(mappedBy = "member")
    private List<Notification> notifications;
}
