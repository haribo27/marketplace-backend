package ru.zubtsov.marketplace.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductDto {

    private long id;
    private String name;
    private String description;
    private Integer price;
    private String imageUrl;
}
