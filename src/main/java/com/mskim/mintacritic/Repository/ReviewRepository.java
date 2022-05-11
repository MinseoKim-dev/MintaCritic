package com.mskim.mintacritic.Repository;

import com.mskim.mintacritic.Entity.Album;
import com.mskim.mintacritic.Entity.Review;
import com.mskim.mintacritic.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    ArrayList<Review> findReviewsByUser(User user);

    Optional<Review> findReviewByUserAndAlbum(User user, Album album);

    int countReviewByUserAndAlbum(User user, Album album);

    @Transactional
    void deleteReviewByUserAndAlbum(User user, Album album);

    @Transactional
    void deleteReviewsByUser(User user);

}
