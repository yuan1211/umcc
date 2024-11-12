package kr.co.comwel.umcc.repository.MissionRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.co.comwel.umcc.domain.Mission;
import kr.co.comwel.umcc.domain.QMission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QMission mission = QMission.mission;



    @Override
    public List<Mission> dynamicQueryWithBooleanBuilder(Float reward, String description){
        BooleanBuilder predicate = new BooleanBuilder();

        if(reward != null){
            predicate.and(mission.reward.eq(reward));
        }
        if (description != null) {
            predicate.and(mission.description.contains(description));
        }
        return jpaQueryFactory
                .select(mission)
                .from(mission)
                .where(predicate)
                .fetch();
    }

}
