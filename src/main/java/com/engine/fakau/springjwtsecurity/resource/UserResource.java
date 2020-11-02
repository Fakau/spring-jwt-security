package com.engine.fakau.springjwtsecurity.resource;
import com.engine.fakau.springjwtsecurity.security.jwt.JwtRequest;
import com.engine.fakau.springjwtsecurity.security.jwt.JwtResponse;
import com.engine.fakau.springjwtsecurity.sercice.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserResource {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        return ResponseEntity.ok(new JwtResponse(userService.authentication(jwtRequest.getLogin(), jwtRequest.getPassword() )));
    }


}
