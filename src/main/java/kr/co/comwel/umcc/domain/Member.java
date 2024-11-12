package kr.co.comwel.umcc.domain;

import jakarta.persistence.*;
import kr.co.comwel.umcc.domain.common.BaseEntity.BaseEntity;
import kr.co.comwel.umcc.domain.enums.Gender;
import kr.co.comwel.umcc.domain.enums.Status;
import kr.co.comwel.umcc.domain.mapping.Member_mission;
import kr.co.comwel.umcc.domain.mapping.Prefer_food;
import lombok.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 50)
    private String address;

    private LocalDate inactive_date;

    @Column(nullable = false, length = 50)
    private String email;

    private Integer point;

    private LocalDate birth;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private Gender gender;

    @Column(columnDefinition = "VARCHAR(20)")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Builder.Default
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> ReviewList = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Prefer_food> Prefer_foodList = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Member_mission> Member_missionList = new ArrayList<>();

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", point=" + point +
                ", birth=" + birth +
                ", address='" + address + '\'' +
                '}';
    }


}
