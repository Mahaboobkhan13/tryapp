package com.example.tryapp.common;

import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor
//@NoArgsConstructor
public class Status {
    private final String act;
    private final String code;
    private final String message;
    private final String token;
}
