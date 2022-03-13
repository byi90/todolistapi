package com.todolistapi.webRestControllers;

import com.auth0.jwt.JWT;
import com.todolistapi.business.service.TokenBlacklistService;
import com.todolistapi.business.service.UserService;
import com.todolistapi.data.entity.JwtTokenBlacklist;
import com.todolistapi.data.entity.User;
import com.todolistapi.security.JWTAuthorizationFilter;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@RestController
public class UserRestController {

    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final TokenBlacklistService tokenBlacklistService;


    public UserRestController(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder, TokenBlacklistService tokenBlacklistService) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.tokenBlacklistService = tokenBlacklistService;
    }

    @PostMapping("/signup")
    public ResponseEntity<Void> userSignUp(@RequestBody User user, UriComponentsBuilder builder){
        if (userService.getUserRepository().findByEmail(user.getEmail()) != null){
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        
        //checking is valid format of email
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
                  
		Pattern pat = Pattern.compile(emailRegex);
		
		if (user.getEmail() == null || !pat.matcher(user.getEmail()).matches() || !user.getEmail().contains("gmail"))
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userService.saveUser(user);
        HttpHeaders headers = new HttpHeaders();

        headers.setLocation(builder.path("/users/{userId}").buildAndExpand(user.getUserId()).toUri());

        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

    }

    @ApiOperation(value = "", authorizations = { @Authorization(value="Bearer") })
    @GetMapping("/log-out")
    public ResponseEntity<Void> logoutUser(JwtTokenBlacklist tokenBlacklist, HttpServletRequest request, Authentication authentication) throws ServletException {
        String token = JWTAuthorizationFilter.getToken(request);
        tokenBlacklistService.addTokenToBlacklist(token, tokenBlacklist);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }





}
