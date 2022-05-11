package com.mskim.mintacritic.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

    @JsonBackReference
    @OneToMany(mappedBy = "album")
    private List<Review> reviews;

}
