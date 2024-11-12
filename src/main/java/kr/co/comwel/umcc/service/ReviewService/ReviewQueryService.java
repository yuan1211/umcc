package kr.co.comwel.umcc.service.ReviewService;

import jakarta.transaction.Transactional;
import kr.co.comwel.umcc.domain.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewQueryService {
    Optional<Review> findReview(Long id);
    List<Review> findReviewByCommentAndScore(String comment, Float score);
    //Review createReview(Review review, Float score);

    //@Transactional
    //Review createReview();
}
