package com.kodnest.music.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {
   @GetMapping(value="/login")
	public String login() {
		return "login";
	}
	@GetMapping(value="/registration")
	public String regestration() {
		return "regestration";
	}
	@GetMapping(value="/addsongs")
	public String addSong() {
		return "song";
	}

	@GetMapping("/forgotpassword")
	public String forgotPassword() {
		return "forgotpassword";
	}
}
