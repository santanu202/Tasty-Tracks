package com.santanu.service;

import com.santanu.Exception.ReviewException;
import com.santanu.model.Review;
import com.santanu.model.User;
import com.santanu.request.ReviewRequest;

import java.util.List;

public interface ReviewService {

    public Review submitReview(ReviewRequest review, User user);

    public void deleteReview(Long reviewId) throws ReviewException;

    public double calculateAverageRating(List<Review> reviews);
}
