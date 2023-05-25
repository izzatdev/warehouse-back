package com.example.warehouse.controllers;

import com.example.warehouse.dtos.auth.AuthRequestDto;
import com.example.warehouse.dtos.auth.AuthResponseDto;
import com.example.warehouse.dtos.auth.RegisterRequestDto;
import com.example.warehouse.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationService service;

    @PostMapping("/register")
    public AuthResponseDto register(
            @RequestBody @Validated RegisterRequestDto request
    ) {
        return service.register(request);
    }

    @PostMapping("/login")
    public AuthResponseDto authenticate(
            @RequestBody @Validated AuthRequestDto request
    ) {
        return service.authenticate(request);
    }
}
