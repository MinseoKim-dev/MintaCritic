package com.mskim.mintacritic.Service;

import com.mskim.mintacritic.Entity.Album;
import com.mskim.mintacritic.Entity.Review;
import com.mskim.mintacritic.Entity.User;
import com.mskim.mintacritic.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    AlbumService albumService;

    @Autowired
    UserService userService;

    public ArrayList<Review> findReviewByUser(String userid) {
        User searchedUser = userService.findUserByID(userid).orElseGet(() -> new User("", "", ""));
        return reviewRepository.findReviewsByUser(searchedUser);
    }

    public Review findReviewByUserAndAlbum(String artist, String title, String userid) {
        Optional<Album> target = albumService.findAlbumByArtistAndTitle(artist, title);
        Album album = target.orElseGet(() -> new Album("", "", ""));
        User searchedUser = userService.findUserByID(userid).orElseGet(() -> new User("", "", ""));

        return reviewRepository.findReviewByUserAndAlbum(searchedUser, album).orElseGet(() -> new Review(0, "", album, searchedUser));
    }

    public Review save(String artist, String title, String userid, int rate, String comment) {
        Optional<Album> target = albumService.findAlbumByArtistAndTitle(artist, title);
        Album album = target.orElseGet(() -> new Album("", "", ""));
        User searchedUser = userService.findUserByID(userid).orElseGet(() -> new User("", "", ""));
        if (reviewRepository.countReviewByUserAndAlbum(searchedUser, album) > 0) {
            return new Review(0, "!!exist", album, searchedUser);
        }
        Review generatedReview = new Review(rate, comment, album, searchedUser);
        reviewRepository.save(generatedReview);
        return generatedReview;
    }

    public void modifyReview(String artist, String title, String userid, int rate, String comment) {
        Optional<Album> searchedAlbum = albumService.findAlbumByArtistAndTitle(artist, title);
        Optional<User> searchedUser = userService.findUserByID(userid);

        if (searchedAlbum.isPresent() && searchedUser.isPresent()) {
            Optional<Review> target = reviewRepository.findReviewByUserAndAlbum(searchedUser.get(), searchedAlbum.get());
            if (target.isPresent()) {
                target.get().setRate(rate);
                target.get().setComment(comment);
                reviewRepository.save(target.get());
            }
        } else {
            System.out.println(searchedAlbum.isPresent());
            System.out.println(searchedUser.isPresent());
        }
    }

    public void deleteReviewByUser(String userid) {
        User searchedUser = userService.findUserByID(userid).orElseGet(() -> new User("", "", ""));
        reviewRepository.deleteReviewsByUser(searchedUser);
    }

    public void deleteReviewByUserAndAlbum (String artist, String title, String userid) {
        Optional<Album> searched = albumService.findAlbumByArtistAndTitle(artist, title);
        Album album = searched.orElseGet(() -> new Album("", "", ""));
        User searchedUser = userService.findUserByID(userid).orElseGet(() -> new User("", "", ""));
        reviewRepository.deleteReviewByUserAndAlbum(searchedUser, album);
    }

}
