package com.mskim.mintacritic.Repository;

import com.mskim.mintacritic.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findUserByUserID(String userID);

    @Transactional
    void deleteUserByUserID(String userID);

}
