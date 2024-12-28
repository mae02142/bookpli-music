package com.project.bookpli_music.controller;

import com.project.bookpli_music.common.response.BaseResponse;
import com.project.bookpli_music.service.MusicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/musicservice")
public class MusicController {
    private final MusicService musicService;

    @GetMapping("/album/{albumId}")
    public BaseResponse<Map<String, Object>> getAlbumTracks(
            @PathVariable String albumId,
            @CookieValue(value = "jwt", required = false) String jwt
    ) {
        Map<String, Object> response = musicService.getAlbumTracks(albumId, jwt);
        return new BaseResponse<>(response);
    }

    @GetMapping
    public BaseResponse<Map<String, Object>> getMyPlaylist(
            @CookieValue(value = "jwt", required = false) String jwt
    ) {
        Map<String, Object> playlists = musicService.getUserPlaylists(jwt);
        return new BaseResponse<>(playlists);
    }

    @GetMapping("/playlist/{playlistId}")
    public BaseResponse<Map<String, Object>> getPlaylistWithMusic(
            @PathVariable String playlistId,
            @CookieValue(value = "jwt", required = false) String jwt
    ) {
        Map<String, Object> music = musicService.getPlaylistWithMusic(playlistId, jwt);
        return new BaseResponse<>(music);
    }

    @PostMapping("{spotifyId}")
    public BaseResponse<Map<String, Object>> createPlaylist(
            @PathVariable String spotifyId,
            @RequestBody Map<String, Object> requestBody,
            @CookieValue(value = "jwt", required = false) String jwt
    ) {
        Map<String, Object> response = musicService.createPlaylist(spotifyId, requestBody, jwt);
        return new BaseResponse<>(response);
    }

    @DeleteMapping("/playlist/{playlistId}/tracks")
    public BaseResponse<Void> deleteTrack(
            @PathVariable String playlistId,
            @RequestBody Map<String, String> requestBody,
            @CookieValue(value = "jwt", required = false) String jwt
    ) {
        musicService.deleteTrack(playlistId, requestBody.get("uri"), jwt);
        return new BaseResponse<>();
    }

    @PutMapping("/playlist/{playlistId}")
    public BaseResponse<Void> updatePlaylistTitle(
            @PathVariable String playlistId,
            @RequestBody Map<String, String> request,
            @CookieValue(value = "jwt", required = false) String jwt
    ) {
        musicService.updatePlaylistTitle(playlistId, request, jwt);
        return new BaseResponse<>();
    }

    @DeleteMapping("/playlist/{playlistId}")
    public BaseResponse<Void> deletePlaylist(
            @PathVariable String playlistId,
            @CookieValue(value = "jwt", required = false) String jwt
    ) {
        musicService.deletePlaylist(playlistId, jwt);
        return new BaseResponse<>();
    }

    @PostMapping("/playlist/{playlistId}")
    public BaseResponse<Void> addPlaylist(
            @PathVariable String playlistId,
            @RequestBody Map<String, Object> request,
            @CookieValue(value = "jwt", required = false) String jwt
    ) {
        musicService.addPlaylist(playlistId, request, jwt);
        return new BaseResponse<>();
    }
}
