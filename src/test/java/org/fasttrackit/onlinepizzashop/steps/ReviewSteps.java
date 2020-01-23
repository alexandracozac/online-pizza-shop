package org.fasttrackit.onlinepizzashop.steps;

import org.fasttrackit.onlinepizzashop.domain.Review;
import org.fasttrackit.onlinepizzashop.service.ReviewService;
import org.fasttrackit.onlinepizzashop.transfer.review.SaveReviewRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;


@Component
public class ReviewSteps {

    @Autowired
    private ReviewService reviewService;

    public Review createReview(){

        SaveReviewRequest request = new SaveReviewRequest();
        request.setContent("Good pizza!");

        Review review = reviewService.createReview(request);

        assertThat(review, notNullValue());
        assertThat(review.getId(), greaterThan(0L));
        assertThat(review.getContent(), is(review.getContent()));

        return review;






    }


}
