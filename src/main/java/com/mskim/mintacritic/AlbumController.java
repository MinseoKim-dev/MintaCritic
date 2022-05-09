package com.mskim.mintacritic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @GetMapping("")
    public ArrayList<Album> getAllAlbums() {
        return albumService.findAll();
    }

    @PostMapping("")
    public Album writeReview(@RequestBody Album album) {
        return albumService.save(album);
    }

    @GetMapping("/{artist}/{title}")
    public Album viewReview(@PathVariable String artist, @PathVariable String title) {
        Optional<Album> target = albumService.findAlbumByArtistAndTitle(artist, title);
        return target.orElseGet(() -> new Album("", "", 0, "", "", ""));
    }

    @PutMapping("/{artist}/{title}")
    public void modifyReview(@PathVariable String artist, @PathVariable String title, @RequestBody int rate, @RequestBody String comment) {
        albumService.updateAlbum(artist, title, rate, comment);
    }

    @DeleteMapping("/{artist}/{title}")
    public void deleteReview(@PathVariable String artist, @PathVariable String title) {
        albumService.deleteAlbum(artist, title);
    }
}
