package com;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeTest {
	
	@GetMapping("/welcome")
	public String welcome() {
		return "welcomeeee";
	}
}
