package com.example.scheduler.controllers;

import com.example.scheduler.controllers.DTO.AuthenticationRequest;
import com.example.scheduler.controllers.DTO.AuthenticationResponse;
import com.example.scheduler.services.UserDetailService;
import com.example.scheduler.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HomeController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailService userDetailService;

    @Autowired
    private JwtUtil jwtTokenUtil;


    @PostMapping("/auth")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        System.out.println("auth");
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw  new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails  = userDetailService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        System.out.println(jwt);
        return ResponseEntity.ok(new AuthenticationResponse(jwt);

    }
}
