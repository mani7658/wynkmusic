// package com.kodnest.music.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.kodnest.music.entity.Song;
//import com.kodnest.music.entity.User;
//import com.kodnest.music.model.LoginData;
//import com.kodnest.music.service.SongService;
//import com.kodnest.music.service.UserService;
//
//import jakarta.servlet.http.HttpSession;
//@CrossOrigin("*")
//@Controller
//public class UserController {
//	@Autowired	
//	UserService	us;
//	@Autowired	
//	SongService	ss;
//	@PostMapping(value="/registration")	
//	public String postUser(@ModelAttribute User user) {
//		User existDetails=us.emailExist(user);
//
//		if(existDetails==null) {
//			us.postUser(user);
//			System.err.println("user added successfull");
//		}
//		else {
//			System.out.println("duplicate records");
//		}
//		return "login";
//
//	}
//	@PostMapping(value="/validate")
//public String addUser(@RequestBody LoginData logindata) {
//		System.out.println(logindata+">>>");
//	return "customerhome";
//	//@PostMapping(value="/validate")
////	public String addUser(@RequestBody LoginData logindata, HttpSession session,Model model) {
////		String email=logindata.getEmail();
////		String password=logindata.getPassword();
////		System.out.println(logindata.getEmail()+"  "+ logindata.getPassword()+"  login");
////
////if(us.validUser(email, password)==true) {
////			
////			session.setAttribute("email", email);
////			
////			String role=us.getRole(logindata.getEmail());
////			User userstatus=us.isPremium(email);
////			if(role.equals("Admin")) {
////				return "adminhome";
////			}
////			else if(userstatus.isPremium()) {
////			
////				List<Song>songslist = ss.fetchAllSongs();
////				model.addAttribute("songs",songslist);
////		        model.addAttribute("isPremium", userstatus);
////				return "viewsongs";
////			}
////			else {
////				return "customerhome";
////			}
////		}
////		else {
////			return "login";
////		}
////		
//	}
//	@GetMapping("/logout")
//	public String logout(HttpSession session) {
//		session.invalidate();
//		return "login";
//	}
//	@PostMapping("/updatepassword")
//	public String updatePassword(@RequestParam ("email") String email,@RequestParam("password")
//	                String password,@RequestParam ("password") String confirmPassword ) {
//		if(password.equals(confirmPassword)) {
//			us.updatePassword(email,password);
//		}
//		return "login";
//	}
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kodnest.music.entity.Song;
import com.kodnest.music.entity.User;
import com.kodnest.music.service.SongService;
import com.kodnest.music.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired	
	UserService	us;
	@Autowired	
	SongService	ss;
	@PostMapping(value="/registration")	
	public String postUser(@ModelAttribute User user) {
		User existDetails=us.emailExist(user);

		if(existDetails==null) {
			us.postUser(user);
			System.err.println("user added successfull");
		}
		else {
			System.out.println("duplicate records");
		}
		return "login";

	}
	@PostMapping(value="/validate")
	public String addUser(@RequestParam("email") String email,@RequestParam("password") 
	                  String password,HttpSession session,Model model) {
		
		
		System.out.println(email+"   "+ password+"  login");
		if(us.validUser(email, password)==true) {
			
			session.setAttribute("email", email);
			
			String role=us.getRole(email);
			User userstatus=us.isPremium(email);
			if(role.equals("Admin")) {
				return "adminhome";
			}
			else if(userstatus.isPremium()) {
			
				List<Song>songslist = ss.fetchAllSongs();
				model.addAttribute("songs",songslist);
		        model.addAttribute("isPremium", userstatus);
				return "viewsongs";
			}
			else {
				return "customerhome";
			}
		}
		else {
			return "login";
		}
		
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}
	@PostMapping("/updatepassword")
	public String updatePassword(@RequestParam ("email") String email,@RequestParam("password")
	                String password,@RequestParam ("password") String confirmPassword ) {
		if(password.equals(confirmPassword)) {
			us.updatePassword(email,password);
		}
		return "login";
	}
		
}

