package org.cwc.productservice.service;

import org.cwc.productservice.model.Product;
import org.cwc.productservice.payload.ProductRequest;
import org.cwc.productservice.payload.ProductResponse;

import java.util.List;

public interface ProductService {

    public Product createProduct(ProductRequest productRequest);

    public Product updateProduct(int productId, ProductRequest productRequest);
    public ProductResponse getProduct(int productId);

    public List<ProductResponse> getAllProducts();

    public void deleteProduct(int productId);
    public void processUserProductInteraction(String message);

}
