package org.cwc.userservice.payload;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class UserResponse {

    private String userId;
    private String name;
    private String email;
}
