package ru.zubtsov.marketplace.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class JwtResponse {

    private String token;
}
