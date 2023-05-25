package com.example.warehouse.services.impls;

import com.example.warehouse.dtos.auth.AuthRequestDto;
import com.example.warehouse.dtos.auth.AuthResponseDto;
import com.example.warehouse.dtos.auth.RegisterRequestDto;
import com.example.warehouse.entities.User;
import com.example.warehouse.repository.UserDao;
import com.example.warehouse.security.JwtService;
import com.example.warehouse.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserDao repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponseDto register(RegisterRequestDto request) {
        if (!Objects.equals(request.getPassword(), request.getPrePassword())) {
            return AuthResponseDto.builder().token(null).message("Parollar mos emas").build();
        }

        var user = User.builder()
                .email(request.getEmail())
                .fullName(request.getFullName())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(User.Role.ROLE_EMPLOYER)
                .build();

        if (repository.findByEmail(request.getEmail().trim()).isPresent()) {
            return AuthResponseDto.builder().token(null).message("Ushbu email registratsiya qilingan").build();
        }
        try {
            repository.save(user);
        } catch (Exception e) {
            return AuthResponseDto.builder().token(null).message("Ro'yxatdan o'tib bo'lmadi").build();
        }
        var jwtToken = jwtService.generateToken(user);
        return AuthResponseDto.builder().token(jwtToken).message("Success").build();
    }

    @Override
    public AuthResponseDto authenticate(AuthRequestDto request) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
            var user = repository.findByEmail(request.getEmail()).orElseThrow();
            var jwtToken = jwtService.generateToken(user);
            return AuthResponseDto.builder().token(jwtToken).message("Success").build();
        } catch (Exception e) {
            return AuthResponseDto.builder().token(null).message("Login yoki parolda xatolik").build();
        }
    }
}
