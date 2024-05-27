//package com.kodnest.music.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.kodnest.music.entity.Song;
//import com.kodnest.music.service.SongService;
//
//@Controller
//public class SongController {
//  @Autowired
//	SongService songService;
//	@PostMapping(value="/addsong")
//	public String addSong(@ModelAttribute Song song) {
//		System.out.println(song);
//		boolean existSong=songService.getSongName(song);
//		if(existSong) {
//			songService.addSong(song);
//		}else {
//			System.out.println("duplicate song");
//		}
//		
//		return "adminhome";
//	}
//	@GetMapping("/playsongs")
//	public String playSongs(Model model){
//		boolean premium=true;
//		if(premium) {						
//				List<Song> songsList=songService.getSongs();
//				model.addAttribute("songs",songsList);				
//				return "viewsongs";
//		
//		}
//		else {
//			return "pay";
//		}
//		
//	}
//	@GetMapping("/addplaylist")
//	public String viewSongs1(Model model){							
//				List<Song> songsList=songService.getSongs();
//				model.addAttribute("songs",songsList);				
//				return "addplaylist";
//		
//	}
//	@GetMapping("/viewsongs")
//	public @ResponseBody List<Song> viewsongs() {
//	    return  songService.fetchAllSongs();
//		
//	}
//	
//	
//}
package com.kodnest.music.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodnest.music.entity.Song;
import com.kodnest.music.service.SongService;

@Controller
public class SongController {
  @Autowired
	SongService songService;
	@PostMapping(value="/addsong")
	public String addSong(@ModelAttribute Song song) {
		System.out.println(song);
		boolean existSong=songService.getSongName(song);
		if(existSong) {
			songService.addSong(song);
		}else {
			System.out.println("duplicate song");
		}
		
		return "adminhome";
	}
	@GetMapping("/playsongs")
	public String playSongs(Model model){
		boolean premium=true;
		if(premium) {						
				List<Song> songsList=songService.getSongs();
				model.addAttribute("songs",songsList);				
				return "viewsongs";
		
		}
		else {
			return "pay";
		}
		
	}
	@GetMapping("/addplaylist")
	public String viewSongs1(Model model){							
				List<Song> songsList=songService.getSongs();
				model.addAttribute("songs",songsList);				
				return "addplaylist";
		
	}
	@GetMapping("/viewsongs")
	public String viewSongs(Model model){							
			List<Song> songsList=songService.getSongs();
				model.addAttribute("songs",songsList);				
				return "viewsongs";	
		
	}
	
	
}
