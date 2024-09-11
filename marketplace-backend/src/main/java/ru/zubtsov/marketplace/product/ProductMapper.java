package ru.zubtsov.marketplace.product;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {

    Product mapToProduct(NewProductRequest request);

    ProductDto mapToProductDto(Product product);
}
