package com.mskim.mintacritic.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="album")
public class Album {

    private String artist;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;

    @Column(name="coverarturl")
    private String coverArtUrl;


    @Builder
    public Album(String artist, String title, String coverArtUrl) {
        this.artist = artist;
        this.title = title;
        this.coverArtUrl = coverArtUrl;
    }

    @OneToMany(mappedBy = "album", cascade = CascadeType.REMOVE)
    private ArrayList<Review> reviews;

}
