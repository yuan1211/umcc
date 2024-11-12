package kr.co.comwel.umcc.repository.ReviewRepository;

import kr.co.comwel.umcc.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewRepositoryCustom {
}
