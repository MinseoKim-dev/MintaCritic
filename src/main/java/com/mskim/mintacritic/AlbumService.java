package com.mskim.mintacritic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class AlbumService {

    @Autowired
    AlbumRepository albumRepository;

    public ArrayList<Album> findAll() {
        ArrayList<Album> albums = new ArrayList<>(albumRepository.findAll());
        return albums;
    }

    public Optional<Album> findAlbumByArtistAndTitle(String artist, String title) {
        return albumRepository.findAlbumByArtistAndTitle(artist, title);
    }

    public Album save(Album album) {
        albumRepository.save(album);
        return album;
    }

    public ArrayList<Album> findAlbumByArtist(String artist) {
        return albumRepository.findAlbumsByArtist(artist);
    }

    public void updateAlbum(String artist, String title, int rate, String comment) {
        Optional<Album> target = albumRepository.findAlbumByArtistAndTitle(artist, title);
        if (target.isPresent()) {
            target.get().setRate(rate);
            target.get().setComment(comment);
        }
    }

    public void deleteAlbum(String artist, String title) {
        albumRepository.deleteAlbumByArtistAndTitle(artist, title);
    }

}
