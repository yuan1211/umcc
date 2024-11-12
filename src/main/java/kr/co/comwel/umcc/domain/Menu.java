package kr.co.comwel.umcc.domain;

import jakarta.persistence.*;
import lombok.*;
import kr.co.comwel.umcc.domain.common.BaseEntity.BaseEntity;


@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Menu extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

}
