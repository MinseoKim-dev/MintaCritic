package com.mskim.mintacritic;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface AlbumRepository extends JpaRepository<Album, Long> {

    public Optional<Album> findAlbumByArtistAndTitle(String artist, String title);

    public void deleteAlbumByArtistAndTitle(String artist, String title);

}
