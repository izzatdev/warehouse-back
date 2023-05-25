package com.example.warehouse.services;

import com.example.warehouse.dtos.auth.AuthRequestDto;
import com.example.warehouse.dtos.auth.AuthResponseDto;
import com.example.warehouse.dtos.auth.RegisterRequestDto;

public interface AuthenticationService {
    AuthResponseDto register(RegisterRequestDto request);

    AuthResponseDto authenticate(AuthRequestDto request);
}