package com.mskim.mintacritic.Service;

import com.mskim.mintacritic.Entity.Album;
import com.mskim.mintacritic.Repository.AlbumRepository;
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

    public Album save(String artist, String title, String coverArtUrl) {
        Album album = new Album(artist, title, coverArtUrl);
        albumRepository.save(album);
        return album;
    }

    public ArrayList<Album> findAlbumByArtist(String artist) {
        return albumRepository.findAlbumsByArtist(artist);
    }

    public void updateAlbum(String artist, String title, String coverArtUrl) {
        Optional<Album> target = albumRepository.findAlbumByArtistAndTitle(artist, title);
        target.ifPresent(album -> album.setCoverArtUrl(coverArtUrl));
    }

    public void deleteAlbum(String artist, String title) {
        albumRepository.deleteAlbumByArtistAndTitle(artist, title);
    }

}
