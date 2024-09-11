package ru.zubtsov.marketplace.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class JwtRequest {

    @NotBlank
    @Size(min = 4, max = 100,
            message = "Длина имени пользователя должна быть от 5 до 30 символов")
    private String username;
    @NotBlank
    @Size(min = 4, max = 75,
            message = "Длина пароля должна быть от 5 до 75 символов")
    private String password;
}
