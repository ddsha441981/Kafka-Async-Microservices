package org.cwc.productservice.payload;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ProductRequest {
    private int productId;
    private String name;
    private String description;
    private double price;
}
