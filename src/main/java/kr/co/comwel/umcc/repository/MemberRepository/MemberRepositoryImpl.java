package kr.co.comwel.umcc.repository.MemberRepository;


import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.co.comwel.umcc.domain.Member;
import kr.co.comwel.umcc.domain.QMember;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom{
    private final JPAQueryFactory queryFactory;
    private final QMember member = QMember.member;

    @Override
    public List<Member> dynamicQueryWithBooleanBuilder(String name, Integer point,
                                                       String email, LocalDate birth,
                                                       String address){
        BooleanBuilder predicate = new BooleanBuilder();

        if (name != null){
            predicate.and(member.name.eq(name));
        }

        if (point != null){
            predicate.and(member.point.goe(point));
        }

        if (email != null) {
            predicate.and(member.email.like("%" + email + "%"));
        }
        if (address != null) {
            predicate.and(member.address.like("%" + address + "%"));
        }

        if (birth != null){
            predicate.and(member.birth.eq(birth));
        }

        return queryFactory
                .select(member)
                .from(member)
                .where(predicate)
                .fetch();
    }
}

