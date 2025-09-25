package com.klu.security;

import com.klu.model.Playlist;
import com.klu.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistSecurityService {

    @Autowired
    private PlaylistRepository playlistRepository;

    public List<Playlist> getPlaylists() {
        return playlistRepository.findAll();
    }

    public Playlist createPlaylist(Playlist playlist) {
        return playlistRepository.save(playlist);
    }
}
