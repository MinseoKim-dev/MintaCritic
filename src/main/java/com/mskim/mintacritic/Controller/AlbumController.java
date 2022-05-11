package com.mskim.mintacritic.Controller;

import com.mskim.mintacritic.Service.AlbumService;
import com.mskim.mintacritic.Entity.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/albums")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @GetMapping("")
    public ArrayList<Album> getAllAlbums() {
        return albumService.findAll();
    }

    @PostMapping("")
    public Album registerAlbum(@RequestParam String artist, @RequestParam String title, @RequestParam String coverArtUrl) {
        return albumService.save(artist, title, coverArtUrl);
    }

    @GetMapping("/{artist}")
    public ArrayList<Album> getAllAlbumsByArtist(@PathVariable String artist) {
        return albumService.findAlbumByArtist(artist);
    }

    @GetMapping("/{artist}/{title}")
    public Album viewAlbum(@PathVariable String artist, @PathVariable String title) {
        Optional<Album> target = albumService.findAlbumByArtistAndTitle(artist, title);
        return target.orElseGet(() -> new Album("", "", ""));
    }

    @PutMapping("/{artist}/{title}")
    public String modifyAlbum(@PathVariable String artist, @PathVariable String title, @RequestParam String coverArtUrl) {
        albumService.updateAlbum(artist, title, coverArtUrl);
        return "Success!";
    }

    @DeleteMapping("/{artist}/{title}")
    public void deleteAlbum(@PathVariable String artist, @PathVariable String title) {
        albumService.deleteAlbum(artist, title);
    }
}
