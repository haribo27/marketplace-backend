package ru.zubtsov.marketplace.product;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Validated
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ProductDto saveProduct(@RequestBody @Valid NewProductRequest request) {
        return productService.saveProduct(request);
    }

    @GetMapping
    public Map<String, Object> findAllProducts(@RequestParam(name = "page", defaultValue = "1")
                                                @Min(0) Integer page,
                                               @RequestParam(name = "size", defaultValue = "9")
                                            @Min(1) @Max(100) Integer size) {
        return productService.pagingProducts(page,size);
    }

    @GetMapping("{productId}")
    public ProductDto findProductById(@PathVariable long productId) {
        return productService.findProductById(productId);
    }


}
