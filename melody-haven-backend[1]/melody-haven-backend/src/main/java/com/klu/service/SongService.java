package com.klu.service;

import com.klu.model.Song;
import com.klu.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {

    @Autowired
    private SongRepository songRepository;

    // Get all songs
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    // Add new song
    public Song addSong(Song song) {
        return songRepository.save(song);
    }

    // Get song by ID
    public Optional<Song> getSongById(Long id) {
        return songRepository.findById(id);
    }

    // Delete song by ID
    public void deleteSong(Long id) {
        songRepository.deleteById(id);
    }
}
