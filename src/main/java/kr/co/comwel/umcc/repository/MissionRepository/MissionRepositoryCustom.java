package kr.co.comwel.umcc.repository.MissionRepository;

import kr.co.comwel.umcc.domain.Mission;


import java.util.List;

public interface MissionRepositoryCustom {
    List<Mission> dynamicQueryWithBooleanBuilder(Float reward, String description);
}
