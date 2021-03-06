package org.fasttrackit.onlinepizzashop.web;


import org.fasttrackit.onlinepizzashop.domain.Review;
import org.fasttrackit.onlinepizzashop.service.ReviewService;
import org.fasttrackit.onlinepizzashop.transfer.review.AddReviewToProductRequest;
import org.fasttrackit.onlinepizzashop.transfer.review.SaveReviewRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;
    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;

    }


    @PostMapping
    public ResponseEntity<Review>createReview(@RequestBody @Valid SaveReviewRequest request) {
        Review review = reviewService.createReview(request);
        return new ResponseEntity<>(review, HttpStatus.CREATED);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Review> getReview(@PathVariable("id") long id ) {
        Review review = reviewService.getReview(id);
        return new ResponseEntity<>(review, HttpStatus.OK);

    }
    @PutMapping
    public ResponseEntity addReviewToProduct( @RequestBody  @Valid AddReviewToProductRequest request) {
        reviewService.addReviewToProduct(request);
        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }


}
