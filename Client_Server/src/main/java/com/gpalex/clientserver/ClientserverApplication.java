package com.gpalex.clientserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class ClientserverApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(ClientserverApplication.class, args);
	}

    //@Value("${user.roleprop}")
    @Value("${user.role}")
    private String role;

    @Value("${user.pwd}")
    private String pwd;

  
    @GetMapping(
      value = "/whoami/{username}",  
      produces = MediaType.TEXT_PLAIN_VALUE)
    public String whoami(@PathVariable("username") String username) {
        return String.format("Hello! You're %s and you'll become a(n) %s with pwd %s...\n", username, role, pwd);
    }
	
	
}
