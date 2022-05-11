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
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @GetMapping("/{userid}")
    public ArrayList<Review> viewAllReviewByUser(@PathVariable String userid) {
        return reviewService.findReviewByUser(userid);
    }

    @DeleteMapping("/{userid}")
    public void deleteAllReviewByUser(@PathVariable String userid) {
        reviewService.deleteReviewByUser(userid);
    }

    @GetMapping("/{artist}/{title}/{userid}")
    public Review viewReview(@PathVariable String artist, @PathVariable String title, @PathVariable String userid) {
        return reviewService.findReviewByUserAndAlbum(artist, title, userid);
    }

    @PostMapping("/{artist}/{title}/{userid}")
    public Review writeReview(@PathVariable String artist, @PathVariable String title, @PathVariable String userid, @RequestParam int rate, @RequestParam String comment) {
        return reviewService.save(artist, title, userid, rate, comment);
    }

    @PutMapping("/{artist}/{title}/{userid}")
    public String modifyReview(@PathVariable String artist, @PathVariable String title, @PathVariable String userid, @RequestParam int rate, @RequestParam String comment) {
        reviewService.modifyReview(artist, title, userid, rate, comment);
        return "Success!";
    }

    @DeleteMapping("/{artist}/{title}/{userid}")
    public void deleteReview(@PathVariable String artist, @PathVariable String title, @PathVariable String userid) {
        reviewService.deleteReviewByUserAndAlbum(artist, title, userid);
    }


}
