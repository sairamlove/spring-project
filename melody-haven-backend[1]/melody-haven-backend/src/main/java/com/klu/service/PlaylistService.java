package com.klu.service;

import com.klu.model.Playlist;
import com.klu.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    // Get all playlists
    public List<Playlist> getPlaylists() {
        return playlistRepository.findAll();
    }

    // Create new playlist
    public Playlist createPlaylist(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    // Get playlist by ID
    public Optional<Playlist> getPlaylistById(Long id) {
        return playlistRepository.findById(id);
    }

    // Delete playlist by ID
    public void deletePlaylist(Long id) {
        playlistRepository.deleteById(id);
    }
}
