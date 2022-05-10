package com.mskim.mintacritic.Entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.type.StringNVarcharType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="user")
public class User {

    @Id
    private String userID;

    private String password;

    private String nickname;

    @Builder
    public User(String userID, String password, String nickname) {
        this.userID = userID;
        this.password = password;
        this.nickname = nickname;
    }

    @OneToMany(mappedBy = "user")
    private ArrayList<Review> reviews;
}
