package com.winzfast.controller;


import com.winzfast.dto.request.user.LoginRequest;
import com.winzfast.dto.request.user.RegisterRequest;
import com.winzfast.dto.request.user.ResetPasswordRequest;
import com.winzfast.dto.response.user.LoginResponse;
import com.winzfast.dto.response.user.RegisterResponse;
import com.winzfast.dto.response.user.ResetPasswordResponse;
import com.winzfast.exception.DuplicatedDataException;
import com.winzfast.exception.InvalidInputException;
import com.winzfast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auths")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) throws InvalidInputException {
        LoginResponse user = userService.login(loginRequest);
        if (user != null) {
            return new ResponseEntity<>("Login successfully!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Login failed! Invalid username or password.", HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest) {
        try {
            RegisterResponse registerResponse = userService.register(registerRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(registerResponse.getUsername() + " Register successfully!");
        } catch (DuplicatedDataException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User/Email is already exist!");
        }
    }

    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestBody ResetPasswordRequest resetPasswordRequest) {
        try {
            ResetPasswordResponse resetPasswordResponse = userService.resetPassword(resetPasswordRequest);
            return ResponseEntity.ok(resetPasswordResponse.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid input");
        }
    }
}
