package com.example.tryapp.common;

import lombok.*;

@AllArgsConstructor
@Getter
@ToString
public enum StatusCode {

    RECORD_ALREADY_EXIST("error","002","Record already exist"),
    INVALID_CREDENTIALS("error","003","Invalid username or password"),
    INVALID_TOKEN("error","009","Invalid token"),
    RECORD_UPDATED_SUCCESSFULLY("success","004","update completed successfully"),
    RECORD_DOESNT_EXIST("error","005","record does not exist"),
    LOGIN("SUCCUSS","200","login succuss");
    private  String act;
    private  String code;
    private  String message;

}
