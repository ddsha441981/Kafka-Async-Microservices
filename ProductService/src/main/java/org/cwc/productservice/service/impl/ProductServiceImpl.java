package org.cwc.productservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.cwc.productservice.exception.ProductNotFoundException;
import org.cwc.productservice.model.Product;
import org.cwc.productservice.payload.ProductRequest;
import org.cwc.productservice.payload.ProductResponse;
import org.cwc.productservice.repository.ProductRepository;
import org.cwc.productservice.service.ProductService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    @Override
    public Product createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        return this.productRepository.save(product);
    }

    @Override
    public Product updateProduct(int productId, ProductRequest productRequest) {
        Product product = this.productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product not found"));
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        return this.productRepository.save(product);
    }
    @Override
    public ProductResponse getProduct(int productId) {
        Product product = this.productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product not found"));
        return mapToProductResponse(product);
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        List<Product> productList = this.productRepository.findAll();
        return productList.stream().map((product) -> mapToProductResponse(product)).collect(Collectors.toList());
    }

    @Override
    public void deleteProduct(int productId) {
        this.productRepository.deleteById(productId);
    }


    @KafkaListener(topics = "user-product-interactions", groupId = "product-service")
    public void processUserProductInteraction(String message) {
        // Process user-product interaction
        // You can optionally delegate the processing to a service class
    }


    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
