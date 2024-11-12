package kr.co.comwel.umcc.service.ReviewService;

import jakarta.transaction.Transactional;
import kr.co.comwel.umcc.domain.Review;
import kr.co.comwel.umcc.repository.ReviewRepository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static kr.co.comwel.umcc.domain.QReview.review;


@Service
@RequiredArgsConstructor
@Transactional
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final ReviewRepository reviewRepository;

    @Override
    public Optional<Review> findReview(Long id) {
        return reviewRepository.findById(id);
    }

    @Override
    public List<Review> findReviewByCommentAndScore(String comment, Float score) {
        List<Review> filteredReview = reviewRepository.dynamicQueryWithBooleanBuilder(comment, score);

        filteredReview.forEach(Review -> System.out.println("Review: " + review));

        return filteredReview;
    }

    //@Transactional
    //@Override
    //public Review createReview(String comment, Float score){
    //    Review review = new Review();
    //    review.setComment(comment);
    //    review.setScore(score);

    //    return reviewRepository.save(review);
    }

