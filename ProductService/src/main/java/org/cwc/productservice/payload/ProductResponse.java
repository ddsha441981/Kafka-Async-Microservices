package org.cwc.productservice.payload;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ProductResponse {
    private int productId;
    private String name;
    private String description;
    private double price;
}
