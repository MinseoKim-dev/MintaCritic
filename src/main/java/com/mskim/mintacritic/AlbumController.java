package com.mskim.mintacritic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @GetMapping("")
    public ArrayList<Album> getAllAlbums() {
        return albumService.getAllAlbums();
    }

    @PostMapping("")
    public Album writeReview(@RequestBody Album album) {
        return albumService.insertAlbum(album);
    }

    @GetMapping("/{title}")
    public Album viewReview(@PathVariable String title) {
        return albumService.getAlbumByTitle(title);
    }

    @PutMapping("/{title}")
    public void modifyReview(@PathVariable String title, @RequestBody float rate) {
        albumService.updateAlbum(title, rate);
    }

    @DeleteMapping("/{title}")
    public void deleteReview(@PathVariable String title) {
        albumService.deleteAlbum(title);
    }
}
