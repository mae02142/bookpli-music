package com.project.bookpli_music.service;

import com.project.bookpli_music.feign_client.AuthFeignClient;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MusicService {
    private final AuthFeignClient authFeignClient;

    public MusicService(AuthFeignClient authFeignClient) {
        this.authFeignClient = authFeignClient;
    }

    public Map<String, Object> getAlbumTracks(String albumId, String jwt) {
        return authFeignClient.getAlbumTracks(albumId, "Bearer " + jwt);
    }

    public Map<String, Object> getUserPlaylists(String jwt) {
        return authFeignClient.getUserPlaylists("Bearer " + jwt);
    }

    public Map<String, Object> getPlaylistWithMusic(String playlistId, String jwt) {
        return authFeignClient.getPlaylistWithMusic(playlistId, "Bearer " + jwt);
    }

    public Map<String, Object> createPlaylist(String spotifyId, Map<String, Object> request, String jwt) {
        return authFeignClient.createPlaylist(spotifyId, request, "Bearer " + jwt);
    }

    public void updatePlaylistTitle(String playlistId, Map<String, String> request, String jwt) {
        authFeignClient.updatePlaylistTitle(playlistId, request, "Bearer " + jwt);
    }

    public void deletePlaylist(String playlistId, String jwt) {
        authFeignClient.deletePlaylist(playlistId, "Bearer " + jwt);
    }

    public void addPlaylist(String playlistId, Map<String, Object> request, String jwt) {
        authFeignClient.addPlaylist(playlistId, request, "Bearer " + jwt);
    }

    public void deleteTrack(String playlistId, String trackUri, String jwt) {
        Map<String, Object> track = Map.of("tracks", Map.of("uri", trackUri));
        authFeignClient.deleteTrack(playlistId, track, "Bearer " + jwt);
    }
}
