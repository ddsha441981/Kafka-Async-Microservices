package org.cwc.productservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.cwc.productservice.model.Product;
import org.cwc.productservice.payload.ProductRequest;
import org.cwc.productservice.payload.ProductResponse;
import org.cwc.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    @Autowired
    private final ProductService productService;

    @PostMapping("/")
    public ResponseEntity<Product> createProduct(@RequestBody ProductRequest productRequest) {
        productService.createProduct(productRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> createProduct(@PathVariable("productId") int productId, @RequestBody ProductRequest productRequest) {
        Product updatedProduct = productService.updateProduct(productId, productRequest);
        return new ResponseEntity<>(updatedProduct,HttpStatus.CREATED);
    }


    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponse> getProducts(@PathVariable("productId") int productId) {
        ProductResponse product = productService.getProduct(productId);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    @GetMapping("/productList")
    public ResponseEntity<List<ProductResponse>> getProductsList() {
        List<ProductResponse> allProducts = productService.getAllProducts();
        return new ResponseEntity<>(allProducts,HttpStatus.OK);
    }


    @DeleteMapping("/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable("productId") int productId) {
        productService.deleteProduct(productId);
        return new ResponseEntity<>("Product deleted successfully",HttpStatus.NO_CONTENT);
    }

}
