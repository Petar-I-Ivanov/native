package com.example.demo.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/simple")
public class SimpleApi {

	@GetMapping("/hello")
	public String getHello(@RequestParam String name) {
		return String.format("Hello, %s!", name);
	}
}
