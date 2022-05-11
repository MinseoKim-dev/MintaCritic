package com.mskim.mintacritic.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="user")
public class User {

    @Id
    @Column(name="userid")
    private String userID;

    private String password;

    private String nickname;

    @Builder
    public User(String userID, String password, String nickname) {
        this.userID = userID;
        this.password = password;
        this.nickname = nickname;
    }

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<Review> reviews;
}
