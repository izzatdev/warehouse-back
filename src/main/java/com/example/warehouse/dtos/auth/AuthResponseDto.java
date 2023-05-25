package com.example.warehouse.dtos.auth;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponseDto {
    private String token;
    private String message;
}