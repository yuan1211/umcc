package kr.co.comwel.umcc.repository.ReviewRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.co.comwel.umcc.domain.QReview;
import kr.co.comwel.umcc.domain.Review;

import java.util.List;

public class ReviewRepositoryImpl implements ReviewRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QReview review = QReview.review;

    public ReviewRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<Review> dynamicQueryWithBooleanBuilder(String comment, Float score){
        BooleanBuilder predicate = new BooleanBuilder();

        if (comment != null){
            predicate.and(review.comment.like("%"+comment+"%"));
        }
        if (score != null){
            predicate.and(review.score.goe(score));
        }
        return jpaQueryFactory
                .select(review)
                .from(review)
                .where(predicate)
                .fetch();
    }
}
