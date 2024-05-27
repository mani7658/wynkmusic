package com.kodnest.music.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.music.entity.Playlist;
import com.kodnest.music.repository.PlaylistRepository;
import com.kodnest.music.service.PlaylistService;

@Service
public class PlaylistServiceImpl implements PlaylistService {
@Autowired
PlaylistRepository pr;

@Override
public void addPlaylist(Playlist playlist) {
	pr.save(playlist);
	
}

@Override
public boolean getName(Playlist playlist) {
	  Playlist playlistName=pr.findByName(playlist.getName());
	  if(playlistName==null) {
		  return true;
	  }
	return false;
}
@Override
public List<Playlist> getPlaylist(){
	return pr.findAll();
}

}
