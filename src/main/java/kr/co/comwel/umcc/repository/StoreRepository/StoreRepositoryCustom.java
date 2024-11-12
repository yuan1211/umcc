package kr.co.comwel.umcc.repository.StoreRepository;

import java.util.List;


public interface StoreRepositoryCustom {
    List<Object> dynamicQueryWithBooleanBuilder(String name, Float score);
}
