package com.inglab.balance_management.controller;

import com.inglab.balance_management.dto.request.AuthenticationRequest;
import com.inglab.balance_management.dto.request.RegisterRequest;
import com.inglab.balance_management.dto.response.AuthenticationResponse;
import com.inglab.balance_management.repository.UserRepository;
import com.inglab.balance_management.service.impl.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/public")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;
    private final UserRepository repository;


    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }


    @PostMapping("/verify")
    public ResponseEntity<String> verifyUser(@RequestParam String otp) {
        var user = repository.findByOtp(otp)
                .orElseThrow(() -> new RuntimeException("Invalid or expired OTP"));

        if (user.getOtpExpiry().isBefore(LocalDateTime.now())) {
            return ResponseEntity.badRequest().body("OTP has expired");
        }

        user.setVerified(true);
        user.setOtp(null);
        user.setOtpExpiry(null);
        repository.save(user);

        return ResponseEntity.ok("User verified successfully!");
    }


}