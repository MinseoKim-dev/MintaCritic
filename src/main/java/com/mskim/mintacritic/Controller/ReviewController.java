package com.mskim.mintacritic.Controller;

import com.mskim.mintacritic.Entity.Album;
import com.mskim.mintacritic.Entity.Review;
import com.mskim.mintacritic.Entity.User;
import com.mskim.mintacritic.Service.AlbumService;
import com.mskim.mintacritic.Service.ReviewService;
import com.mskim.mintacritic.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    ReviewService reviewService;
    UserService userService;
    AlbumService albumService;

    @GetMapping("/{userid}")
    public ArrayList<Review> viewAllReviewByUser(@PathVariable String userid) {
        User searchedUser = userService.findUserByID(userid).orElseGet(() -> new User("", "", ""));
        return reviewService.findReviewByUser(searchedUser);
    }

    @DeleteMapping("/{userid}")
    public void deleteAllReviewByUser(@PathVariable String userid) {
        User searchedUser = userService.findUserByID(userid).orElseGet(() -> new User("", "", ""));
        reviewService.deleteReviewByUser(searchedUser);
    }

    @GetMapping("/{artist}/{title}/{userid}")
    public Review viewReview(@PathVariable String artist, @PathVariable String title, @PathVariable String userid) {
        Optional<Album> target = albumService.findAlbumByArtistAndTitle(artist, title);
        Album album = target.orElseGet(() -> new Album("", "", ""));
        User searchedUser = userService.findUserByID(userid).orElseGet(() -> new User("", "", ""));

        return reviewService.findReviewByUserAndAlbum(searchedUser, album).orElseGet(() -> new Review(0, "", album, searchedUser));
    }

    @PostMapping("/{artist}/{title}/{userid}")
    public Review writeReview(@PathVariable String artist, @PathVariable String title, @PathVariable String userid, @RequestBody Review review) {
        Optional<Album> target = albumService.findAlbumByArtistAndTitle(artist, title);
        Album album = target.orElseGet(() -> new Album("", "", ""));
        User searchedUser = userService.findUserByID(userid).orElseGet(() -> new User("", "", ""));

        return reviewService.save(new Review(review.getRate(), review.getComment(), album, searchedUser));
    }

    @PutMapping("/{artist}/{title}/{userid}")
    public String modifyReview(@PathVariable String artist, @PathVariable String title, @PathVariable String userid, @RequestBody Review review) {
        Optional<Album> target = albumService.findAlbumByArtistAndTitle(artist, title);
        Album album = target.orElseGet(() -> new Album("", "", ""));
        User searchedUser = userService.findUserByID(userid).orElseGet(() -> new User("", "", ""));

        reviewService.modifyReview(searchedUser, album, review);
        return "Success!";
    }

    @DeleteMapping("/{artist}/{title}/{userid}")
    public void deleteReview(@PathVariable String artist, @PathVariable String title, @PathVariable String userid) {
        Optional<Album> target = albumService.findAlbumByArtistAndTitle(artist, title);
        Album album = target.orElseGet(() -> new Album("", "", ""));
        User searchedUser = userService.findUserByID(userid).orElseGet(() -> new User("", "", ""));

        reviewService.deleteReviewByUserAndAlbum(searchedUser, album);
    }


}
