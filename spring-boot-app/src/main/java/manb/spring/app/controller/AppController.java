package manb.spring.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import manb.spring.app.model.Greetings;

@RestController
@Api(description="Post API")
public class AppController {

	@Autowired
	private GreetingsService service;
	
	@PostMapping("/hello")
	@ApiOperation(value="Send Greetings")
	@ApiResponses(value= {
			@ApiResponse(code=200, message="Received Greetings")
		}
	)
	public String HelloWord(@Validated @RequestBody Greetings greetings)
	{
		//predicate
		System.out.println(greetings.getGreetings().stream().anyMatch((t) -> t.getFrom().isEmpty()));
		service.process(greetings);
		return "Hello World";
	}
}
