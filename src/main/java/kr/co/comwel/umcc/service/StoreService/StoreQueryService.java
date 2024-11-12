package kr.co.comwel.umcc.service.StoreService;

import kr.co.comwel.umcc.domain.Store;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);
    List<Object> findStoresByNameAndScore(String name, Float score);
}