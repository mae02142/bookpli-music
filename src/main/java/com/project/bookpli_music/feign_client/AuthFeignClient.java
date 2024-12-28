package com.project.bookpli_music.feign_client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(name = "authservice", url = "http://localhost:9003")
public interface AuthFeignClient {

    @GetMapping("/spotify/albums/{albumId}/tracks")
    Map<String, Object> getAlbumTracks(
            @PathVariable("albumId") String albumId,
            @RequestHeader("Authorization") String jwt
    );

    @GetMapping("/spotify/me/playlists")
    Map<String, Object> getUserPlaylists(@RequestHeader("Authorization") String jwt);

    @GetMapping("/spotify/playlists/{playlistId}/tracks")
    Map<String, Object> getPlaylistWithMusic(
            @PathVariable("playlistId") String playlistId,
            @RequestHeader("Authorization") String jwt
    );

    @PostMapping("/spotify/users/{spotifyId}/playlists")
    Map<String, Object> createPlaylist(
            @PathVariable("spotifyId") String spotifyId,
            @RequestBody Map<String, Object> request,
            @RequestHeader("Authorization") String jwt
    );

    @PutMapping("/spotify/playlists/{playlistId}")
    void updatePlaylistTitle(
            @PathVariable("playlistId") String playlistId,
            @RequestBody Map<String, String> request,
            @RequestHeader("Authorization") String jwt
    );

    @DeleteMapping("/spotify/playlists/{playlistId}/followers")
    void deletePlaylist(
            @PathVariable("playlistId") String playlistId,
            @RequestHeader("Authorization") String jwt
    );

    @PostMapping("/spotify/playlists/{playlistId}/tracks")
    void addPlaylist(
            @PathVariable("playlistId") String playlistId,
            @RequestBody Map<String, Object> request,
            @RequestHeader("Authorization") String jwt
    );

    @DeleteMapping("/spotify/playlists/{playlistId}/tracks")
    void deleteTrack(
            @PathVariable("playlistId") String playlistId,
            @RequestBody Map<String, Object> track,
            @RequestHeader("Authorization") String jwt
    );
}

