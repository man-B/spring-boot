package manb.spring.app.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import manb.spring.app.model.Greetings;

@RestController
public class AppController {

	@PostMapping("/hello")
	public String HelloWord(@RequestBody Greetings greetings)
	{
		return "Hello World";
	}
}
