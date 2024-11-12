package kr.co.comwel.umcc.domain.mapping;

import jakarta.persistence.*;
import kr.co.comwel.umcc.domain.Member;
import kr.co.comwel.umcc.domain.Mission;
import kr.co.comwel.umcc.domain.common.BaseEntity.BaseEntity;
import kr.co.comwel.umcc.domain.enums.MissionStatus;
import lombok.*;



@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member_mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(20)")
    private MissionStatus status;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;
}
