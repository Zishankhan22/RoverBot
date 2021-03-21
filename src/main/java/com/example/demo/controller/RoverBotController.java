package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.CurrentPosition;
import com.example.demo.common.Input;
import com.example.demo.service.BotService;

@RestController
@RequestMapping("/RoverBot")
public class RoverBotController {

	@Autowired
	private BotService botService;

	@PostMapping("/getFinalPosition")
	public CurrentPosition getFinalPosition(@RequestBody Input input) {
		System.out.println(input.toString());
		return botService.getFinalPosition(input);
	}

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome";
	}
}
