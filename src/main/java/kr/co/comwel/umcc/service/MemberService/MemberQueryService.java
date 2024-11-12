package kr.co.comwel.umcc.service.MemberService;

import kr.co.comwel.umcc.domain.Member;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MemberQueryService {
    Optional<Member> findMember(Long id);
    List<Member> findMemberAll(String name, Integer point,
                               String email, LocalDate birth, String address);
}
