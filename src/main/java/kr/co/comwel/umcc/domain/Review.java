package kr.co.comwel.umcc.domain;

import jakarta.persistence.*;
import lombok.*;
import kr.co.comwel.umcc.domain.common.BaseEntity.BaseEntity;


@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 50)
    private String comment;

    private Float score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", score=" + score +
                '}';
    }

}
