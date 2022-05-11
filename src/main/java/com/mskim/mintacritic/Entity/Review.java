package com.mskim.mintacritic.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Builder
    public Review(int rate, String comment, Album album, User user) {
        this.rate = rate;
        this.comment = comment;
        this.album = album;
        this.user = user;
    }

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name="album_id")
    private Album album;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    private int rate;
    private String comment;

}
