package ru.zubtsov.marketplace.product;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.zubtsov.marketplace.exception.EntityNotFound;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductDto saveProduct(NewProductRequest request) {
        Product product = productMapper.mapToProduct(request);
        product = productRepository.save(product);
        return productMapper.mapToProductDto(product);
    }

    @Override
    public ProductDto findProductById(long productId) {
        return productRepository.findById(productId)
                .map(productMapper::mapToProductDto)
                .orElseThrow(() -> new EntityNotFound("Product not found"));
    }

    @Override
    public List<ProductDto> findAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::mapToProductDto)
                .toList();
    }

    @Override
    public Map<String, Object> pagingProducts(Integer page, Integer size) {

        Pageable paging = PageRequest.of(page - 1, size);
        Page<Product> pageProducts = productRepository.findAll(paging);

        Map<String, Object> response = new HashMap<>();
        response.put("products", pageProducts.getContent());
        response.put("totalPages", pageProducts.getTotalPages());
        response.put("currentPage", pageProducts.getNumber() + 1);
        response.put("totalItems", pageProducts.getTotalElements());

        return response;
    }
}
