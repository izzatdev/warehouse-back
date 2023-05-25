package com.example.warehouse.dtos.auth;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDto extends AuthRequestDto {
    @NonNull
    private String fullName;

    @NonNull
    private String prePassword;
}
