package com.classroom.Controller;


import com.classroom.Entiry.Role;
import com.classroom.Service.UserService;
import com.classroom.helpers.AuthRequest;
import com.classroom.security.JWT.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    private final UserService userService;

    @Autowired
    public UserController(JwtService jwtService, AuthenticationManager authenticationManager, UserService userService){
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

    @PostMapping("/auth")
    public String authAndGenerateToken(@RequestBody AuthRequest authRequest){

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(authRequest.getUsername());
        }
        else{
            //throw new BadCredentialsException("Invalid username or password");
            return "Invalid username or password";
        }
    }
}
