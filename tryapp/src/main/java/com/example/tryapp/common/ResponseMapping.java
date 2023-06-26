package com.example.tryapp.common;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import org.mapstruct.factory.Mappers;


@Mapper
public interface ResponseMapping {
 ResponseMapping INSTANCE = Mappers.getMapper(ResponseMapping.class);

@Mappings({
        @Mapping(target = "act", source = "statusCode.act"),
        @Mapping(target = "code", source = "statusCode.code"),
        @Mapping(target = "message", source = "statusCode.message"),
        @Mapping(target = "token", source = "jwttoken")
})
 Status baseMapping (StatusCode statusCode,String jwttoken);
}
