package com.mskim.mintacritic.Service;

import com.mskim.mintacritic.Entity.Album;
import com.mskim.mintacritic.Entity.Review;
import com.mskim.mintacritic.Entity.User;
import com.mskim.mintacritic.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    public ArrayList<Review> findReviewByUser(User user) {
        return reviewRepository.findAllByUser(user);
    }

    public Optional<Review> findReviewByUserAndAlbum(User user, Album album) {
        return reviewRepository.findReviewByUserAndAlbum(user, album);
    }

    public Review save(Review review) {
        reviewRepository.save(review);
        return review;
    }

    public void modifyReview(User user, Album album, Review review) {
        Optional<Review> target = reviewRepository.findReviewByUserAndAlbum(user, album);
        if (target.isPresent()) {
            target.get().setRate(review.getRate());
            target.get().setComment(review.getComment());
        }
    }

    public void deleteReviewByUser(User user) {
        reviewRepository.deleteReviewsByUser(user);
    }

    public void deleteReviewByUserAndAlbum (User user, Album album) {
        reviewRepository.deleteReviewByUserAndAlbume(user, album);
    }

}
