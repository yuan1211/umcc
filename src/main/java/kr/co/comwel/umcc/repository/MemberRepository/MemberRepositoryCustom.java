package kr.co.comwel.umcc.repository.MemberRepository;

import kr.co.comwel.umcc.domain.Member;

import java.time.LocalDate;
import java.util.List;

public interface MemberRepositoryCustom {
    List<Member> dynamicQueryWithBooleanBuilder(String name, Integer point, String email, LocalDate birth, String address);
}
