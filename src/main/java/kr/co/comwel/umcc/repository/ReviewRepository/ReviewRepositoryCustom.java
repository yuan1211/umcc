package kr.co.comwel.umcc.repository.ReviewRepository;

import kr.co.comwel.umcc.domain.Review;

import java.util.List;

public interface ReviewRepositoryCustom {
    List<Review> dynamicQueryWithBooleanBuilder(String comment, Float score);
}
