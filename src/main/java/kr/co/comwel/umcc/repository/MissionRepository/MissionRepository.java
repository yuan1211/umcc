package kr.co.comwel.umcc.repository.MissionRepository;

import kr.co.comwel.umcc.domain.Mission;
import kr.co.comwel.umcc.repository.MemberRepository.MemberRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long>, MissionRepositoryCustom {
}
