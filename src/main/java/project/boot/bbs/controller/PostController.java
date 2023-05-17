package project.boot.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/post")
public class PostController {
	
	@GetMapping(value = "/about")
	public String aboutPage() {		
	
		return "post/about";
	}
	
	@GetMapping(value = "/list")
	public String listPage() {		
	
		return "post/list";
	}	
}
