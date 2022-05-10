package com.mskim.mintacritic.Repository;

import com.mskim.mintacritic.Entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Optional;

public interface AlbumRepository extends JpaRepository<Album, Long> {

    Optional<Album> findAlbumByArtistAndTitle(String artist, String title);

    ArrayList<Album> findAlbumsByArtist(String artist);

    @Transactional
    void deleteAlbumByArtistAndTitle(String artist, String title);

}
