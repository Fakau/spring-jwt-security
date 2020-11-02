package com.engine.fakau.springjwtsecurity.resource;
import com.engine.fakau.springjwtsecurity.security.jwt.JwtRequest;
import com.engine.fakau.springjwtsecurity.security.jwt.JwtResponse;
import com.engine.fakau.springjwtsecurity.sercice.dto.UserDTO;
import com.engine.fakau.springjwtsecurity.sercice.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserResource {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        HttpHeaders httpHeaders = new HttpHeaders();
        JwtResponse jwtResponse =new JwtResponse(userService.authentication(jwtRequest.getLogin(), jwtRequest.getPassword()));
        httpHeaders.add("Authorization", jwtResponse.getToken());
        return ResponseEntity.ok(jwtResponse);
    }
    @GetMapping("/user")
    public ResponseEntity<List<UserDTO>> getAll() {
        HttpHeaders httpHeaders = new HttpHeaders();
        return ResponseEntity.ok(userService.getAll());
    }
    @GetMapping("/user/find-by-login")
    public ResponseEntity<Optional<UserDTO>> getAll(@RequestParam("login") String login ) {
        HttpHeaders httpHeaders = new HttpHeaders();
        return ResponseEntity.ok(userService.findOneByLogin(login));
    }




}
