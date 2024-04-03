package org.cwc.userservice.model;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ProductInteractionRequest {

    private String productId;
    private String userId;
    private String action;

}
