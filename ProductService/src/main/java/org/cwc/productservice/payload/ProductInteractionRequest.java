package org.cwc.productservice.payload;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ProductInteractionRequest {

    private int productId;
    private String message;
}
