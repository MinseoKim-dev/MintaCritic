package com.mskim.mintacritic;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="album")
public class Album {

    private String artist;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private int rate;
    private String trackList;
    private String coverArtUrl;
    private String comment;

    @Builder
    public Album(String artist, String title, int rate, String trackList, String coverArtUrl, String comment) {
        this.artist = artist;
        this.title = title;
        this.rate = rate;
        this.trackList = trackList;
        this.coverArtUrl = coverArtUrl;
        this.comment = comment;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


}
