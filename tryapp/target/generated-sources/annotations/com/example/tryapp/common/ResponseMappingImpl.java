package com.example.tryapp.common;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-23T18:22:15+0530",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
public class ResponseMappingImpl implements ResponseMapping {

    @Override
    public Status baseMapping(StatusCode statusCode, String jwttoken) {
        if ( statusCode == null && jwttoken == null ) {
            return null;
        }

        Status.StatusBuilder status = Status.builder();

        if ( statusCode != null ) {
            status.act( statusCode.getAct() );
            status.code( statusCode.getCode() );
            status.message( statusCode.getMessage() );
        }
        status.token( jwttoken );

        return status.build();
    }
}
