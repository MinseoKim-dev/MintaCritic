package com.mskim.mintacritic;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class AlbumDao {

    public static ArrayList<Album> albums;

    public ArrayList<Album> getAllAlbums() {
        return albums;
    }

    public Album getAlbumByTitle(String title) {
        return albums.stream().filter(album->album.getTitle().equals(title))
                .findAny().orElse(new Album("None", "None", 0, "", "", ""));
    }

    public Album insertAlbum(Album album) {
        albums.add(album);
        return album;
    }

    public void updateAlbum(String title, int rate) {
        albums.stream().filter(album->album.getTitle().equals(title))
                .findAny().orElse(new Album("None", "None", 0, "", "", ""))
                .setRate(rate);
    }

    public void deleteAlbum(String title) {
        albums.removeIf(album->album.getTitle().equals(title));
    }

}
