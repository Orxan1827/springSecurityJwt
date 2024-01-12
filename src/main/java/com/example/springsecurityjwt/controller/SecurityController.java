package com.example.springsecurityjwt.controller;

import com.example.springsecurityjwt.model.AuthRequest;
import com.example.springsecurityjwt.service.TokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/home")
public class SecurityController {

    private final TokenManager tokenManager;
    private final AuthenticationManager authenticationManager;

    @GetMapping("/get")
    public ResponseEntity<String> helloJwt(){
        return ResponseEntity.ok("Hello Jwt!..");
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword()));
        }catch (Exception e){
            throw new Exception("invalid username or password");
        }
        return tokenManager.generateToken(authRequest.getUsername());
    }
}
