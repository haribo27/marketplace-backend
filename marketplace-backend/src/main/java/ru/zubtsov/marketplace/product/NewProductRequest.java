package ru.zubtsov.marketplace.product;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class NewProductRequest {

    private long id;
    @NotBlank
    @Size(min = 5, max = 100)
    private String name;
    @NotBlank
    @Size(min = 5,max = 255)
    private String description;
    @NotNull
    private Integer price;
    private String imageUrl;
}
