package ru.zubtsov.marketplace.product;


import java.util.List;
import java.util.Map;

public interface ProductService {

    ProductDto saveProduct(NewProductRequest request);

    ProductDto findProductById(long productId);

    List<ProductDto> findAllProducts();

    Map<String, Object> pagingProducts(Integer page, Integer size);
}
