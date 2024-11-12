package kr.co.comwel.umcc.domain.mapping;

import jakarta.persistence.*;
import kr.co.comwel.umcc.domain.Member;
import kr.co.comwel.umcc.domain.Menu;
import lombok.*;
import kr.co.comwel.umcc.domain.common.BaseEntity.BaseEntity;


@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Prefer_food extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
    private Menu menu;
}
