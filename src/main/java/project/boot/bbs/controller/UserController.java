package project.boot.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import project.boot.bbs.dto.SignUpDTO;
import project.boot.bbs.service.UserService;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/user")
public class UserController {
	
	private final UserService userService;
	
	@GetMapping(value = "/signIn")
	public String signIn() {		
	
		return "user/signIn";
	}
	
	@GetMapping(value = "/signUp")
	public String signUp() {		
	
		return "user/signUp";
	}
	
	@PostMapping(value = "/signUp/insert")
	public String signUpInsert(@RequestBody SignUpDTO dto) {
		log.info("signUpDto={}", dto);
		userService.insertUser(dto);
		
		return "redirect:/";
	}
}
