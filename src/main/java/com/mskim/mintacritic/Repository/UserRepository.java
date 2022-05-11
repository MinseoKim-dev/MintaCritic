package com.mskim.mintacritic.Repository;

import com.mskim.mintacritic.Entity.Review;
import com.mskim.mintacritic.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findUserByUserID(String userID);

    int countAllByUserID(String userID);
    int countAllByNickname(String nickname);

    @Transactional
    void deleteUserByUserID(String userID);
}
