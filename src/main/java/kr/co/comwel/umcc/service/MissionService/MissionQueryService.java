package kr.co.comwel.umcc.service.MissionService;

import kr.co.comwel.umcc.domain.Mission;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MissionQueryService {
    Optional<Mission> findMission(Long id);
    List<Mission> findMissionByRewardAndDescription(Float reward, String description);
}
