package org.cwc.userservice.exception;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ErrorResponse {
    private int statusCode;
    private Date timestamp;
    private String message;
    private String description;
    private String path;
}