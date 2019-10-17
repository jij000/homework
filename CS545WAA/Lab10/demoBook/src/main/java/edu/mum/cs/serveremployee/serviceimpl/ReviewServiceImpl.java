package edu.mum.cs.serveremployee.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.serveremployee.domain.Review;
import edu.mum.cs.serveremployee.repository.ReviewRepository;
import edu.mum.cs.serveremployee.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public List<Review> getReviewList() {
        return reviewRepository.findAll();
    }

    @Override
    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review getReviewById(Long reviewid) {
        return reviewRepository.findById(reviewid).get();
    }

}
