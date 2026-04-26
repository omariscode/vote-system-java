package com.omarscode.voting_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class VotingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(VotingSystemApplication.class, args);
	}

	@GetMapping
	public String check_health(){
		return "Health checked";
	}	

}
