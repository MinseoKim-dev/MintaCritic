package com.mskim.mintacritic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AlbumService {

    @Autowired
    AlbumDao albumDao;

    public ArrayList<Album> getAllAlbums() {
        return albumDao.getAllAlbums();
    }

    public Album getAlbumByTitle(String title) {
        return albumDao.getAlbumByTitle(title);
    }

    public Album insertAlbum(Album album) {
        return albumDao.insertAlbum(album);
    }

    public void updateAlbum(String title, int rate) {
        albumDao.updateAlbum(title, rate);
    }

    public void deleteAlbum(String title) {
        albumDao.deleteAlbum(title);
    }

}
