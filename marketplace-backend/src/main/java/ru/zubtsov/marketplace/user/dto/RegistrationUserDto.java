package ru.zubtsov.marketplace.user.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import ru.zubtsov.marketplace.user.Role;

import java.util.Collection;

@Data
public class RegistrationUserDto {

    @NotBlank
    @Size(min = 5, max = 100,
            message = "Длина имени пользователя должна быть от 5 до 30 символов")
    private String username;
    @NotBlank
    @Email(message = "Почта должна быть вида user@gmail.com")
    @Size(min = 2, max = 50, message = "Почта должна содержать максимум 50 символов")
    private String email;
    @NotBlank
    @Size(min = 5, max = 75,
            message = "Длина пароля должна быть от 5 до 75 символов")
    private String password;
    @NotBlank
    @Size(min = 5, max = 75,
            message = "Длина пароля должна быть от 5 до 75 символов")
    private String confirmPassword;

}
