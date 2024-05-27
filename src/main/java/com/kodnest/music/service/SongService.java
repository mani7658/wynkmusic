package com.kodnest.music.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kodnest.music.entity.Song;
@Service
public interface SongService {

	void addSong(Song song);

	boolean getSongName(Song song);

	List<Song> getSongs();

	void updateSong(Song song);

	List<Song> fetchAllSongs();
}
