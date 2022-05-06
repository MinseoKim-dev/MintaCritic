package com.mskim.mintacritic;

import java.util.ArrayList;
import java.util.Arrays;

public class Album {

    private String artist;
    private String title;
    private float rate;
    private ArrayList<String> trackList;
    private String coverArtUrl;
    private String comment;

    public Album(String artist, String title, float rate, ArrayList<String> trackList, String coverArtUrl, String comment) {
        this.artist = artist;
        this.title = title;
        this.rate = rate;
        this.trackList = trackList;
        this.coverArtUrl = coverArtUrl;
        this.comment = comment;
    }

    public String getArtist() {
        return this.artist;
    }

    public String getTitle() {
        return this.title;
    }

    public float getRate() {
        return this.rate;
    }

    public ArrayList<String> getTrackList() {
        return this.trackList;
    }

    public String getCoverArtUrl () {
        return this.coverArtUrl;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }




}
