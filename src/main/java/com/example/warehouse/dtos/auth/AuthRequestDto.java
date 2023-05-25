package com.example.warehouse.dtos.auth;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequestDto {
    @NotNull
    protected String password;

    @NotNull
    protected String email;
}