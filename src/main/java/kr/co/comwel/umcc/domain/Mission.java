package kr.co.comwel.umcc.domain;

import kr.co.comwel.umcc.domain.mapping.Member_mission;
import jakarta.persistence.*;
import lombok.*;
import kr.co.comwel.umcc.domain.common.BaseEntity.BaseEntity;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Float reward;

    @Column(nullable = false, length = 50)
    private  String description;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<Member_mission> memberMissionList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @Override
    public String toString() {
        return "Mission{" +
                "reward=" + reward +
                ", description='" + description + '\'' +
                '}';
}}
