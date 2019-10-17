package edu.mum.cs.serveremployee.service;

import java.util.List;

import edu.mum.cs.serveremployee.domain.Review;

public interface ReviewService {
    List<Review> getReviewList();
    Review saveReview(Review review);
    Review getReviewById(Long reviewid);
}
