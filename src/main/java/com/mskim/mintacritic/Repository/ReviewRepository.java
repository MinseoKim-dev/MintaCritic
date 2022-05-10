package com.mskim.mintacritic.Repository;

import com.mskim.mintacritic.Entity.Album;
import com.mskim.mintacritic.Entity.Review;
import com.mskim.mintacritic.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    ArrayList<Review> findAllByUser(User user);

    Optional<Review> findReviewByUserAndAlbum(User user, Album album);

    @Transactional
    void deleteReviewByUserAndAlbume(User user, Album album);

    @Transactional
    void deleteReviewsByUser(User user);

}
