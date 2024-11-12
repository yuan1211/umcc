package kr.co.comwel.umcc.service.MissionService;


import jakarta.transaction.Transactional;
import kr.co.comwel.umcc.domain.Mission;
import kr.co.comwel.umcc.repository.MissionRepository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;

    @Override
    public Optional<Mission> findMission(Long id){
        return missionRepository.findById(id);
    }

    @Override
    public List<Mission> findMissionByRewardAndDescription(Float reward, String description) {
        List<Mission> filteredMission = missionRepository.dynamicQueryWithBooleanBuilder(reward, description);

        filteredMission.forEach(mission -> System.out.println("Mission: " + mission));

        return filteredMission;
    }
}
