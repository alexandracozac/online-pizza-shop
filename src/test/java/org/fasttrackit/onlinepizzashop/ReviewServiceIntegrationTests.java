package org.fasttrackit.onlinepizzashop;



import org.fasttrackit.onlinepizzashop.service.ReviewService;
import org.fasttrackit.onlinepizzashop.steps.ReviewSteps;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ReviewServiceIntegrationTests {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private ReviewSteps reviewSteps;

    @Test
    public void testCreateReview_whenValidRequest_thenShowReview() {
        reviewSteps.createReview();
    }

    }


