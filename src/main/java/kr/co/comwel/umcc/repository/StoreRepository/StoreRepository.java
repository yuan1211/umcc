package kr.co.comwel.umcc.repository.StoreRepository;


import kr.co.comwel.umcc.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;




public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom{

}