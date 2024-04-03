package org.cwc.userservice.payload;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class UserRequest {

    private String userId;
    private String name;
    private String email;
}
