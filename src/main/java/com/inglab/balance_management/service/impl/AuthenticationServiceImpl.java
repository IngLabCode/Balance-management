package com.inglab.balance_management.service.impl;

import com.inglab.balance_management.dto.request.AuthenticationRequest;
import com.inglab.balance_management.model.User;
import com.inglab.balance_management.repository.UserRepository;
import com.inglab.balance_management.dto.request.RegisterRequest;
import com.inglab.balance_management.dto.response.AuthenticationResponse;
import com.inglab.balance_management.enums.Role;
import com.inglab.balance_management.service.inter.OTPServiceInter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final OTPServiceInter otpServiceInter;


        public AuthenticationResponse register(RegisterRequest request) {
        Role role;
        try {
            role = Role.valueOf(request.getRole().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid role: " + request.getRole());
        }

        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .isEnabled(true)
//                .isAccountNonExpired(true)
//                .isAccountNonLocked(true)
//                .isCredentialsNonExpired(true)
                .roles(Set.of(role))
                .build();

        repository.save(user);
        otpServiceInter.generateAndSendOTP(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

}