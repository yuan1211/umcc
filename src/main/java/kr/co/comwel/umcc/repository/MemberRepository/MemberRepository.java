package kr.co.comwel.umcc.repository.MemberRepository;

import kr.co.comwel.umcc.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {

}
