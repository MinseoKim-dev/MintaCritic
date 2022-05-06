package com.mskim.mintacritic;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class AlbumDao {

    public static ArrayList<Album> albums;

    static {
        albums = new ArrayList<>();
        albums.add(new Album("Taylor Swift", "1989", 100, new ArrayList<>(), "", ""));
        albums.add(new Album("Taylor Swift", "Red", 100, new ArrayList<>(), "", ""));
    }

    public ArrayList<Album> getAllAlbums() {
        return albums;
    }

    public Album getAlbumByTitle(String title) {
        return albums.stream().filter(album->album.getTitle().equals(title))
                .findAny().orElse(new Album("None", "None", 0, new ArrayList<>(), "", ""));
    }

    public Album insertAlbum(Album album) {
        albums.add(album);
        return album;
    }

    public void updateAlbum(String title, float rate) {
        albums.stream().filter(album->album.getTitle().equals(title))
                .findAny().orElse(new Album("None", "None", 0, new ArrayList<>(), "", ""))
                .setRate(rate);

    }

    public void deleteAlbum(String title) {
        albums.removeIf(album->album.getTitle().equals(title));
    }

}
