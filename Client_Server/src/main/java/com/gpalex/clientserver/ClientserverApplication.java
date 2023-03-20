package com.gpalex.clientserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@SpringBootApplication
@RestController
public class ClientserverApplication {

  public static void main(String[] args) {
    SpringApplication.run(ClientserverApplication.class, args);
  }

  // @Value("${user.roleprop}")
  @Value("${user.role}")
  private String role;

  @Value("${user.pwd}")
  private String pwd;

  @Operation(summary = "Retrieve user and password")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Found the credentials", content = @Content),
      @ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content),
      @ApiResponse(responseCode = "404", description = "Book not found", content = @Content) }) // @formatter:on

  @GetMapping(value = "/{username}", produces = MediaType.TEXT_PLAIN_VALUE)
  public String whoami(@PathVariable("username") String username) {
    return String.format("Hello! You're %s and you'll become a(n) %s with pwd %s...\n", username, role, pwd);
  }

  @Operation(summary = "Say Hello")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Hello", content = @Content),
      @ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content),
      @ApiResponse(responseCode = "404", description = "Book not found", content = @Content) }) // @formatter:on

  @GetMapping(value = "/hello", produces = MediaType.TEXT_PLAIN_VALUE)
  public String hello() {
    return String.format("Hello");
  }

}
