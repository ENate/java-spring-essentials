package com.minejava.mapstruct.mapstructservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.minejava.mapstruct.mapstructservice.dto.BasicUserDTO;
import com.minejava.mapstruct.mapstructservice.model.BasicUser;

@Mapper
public interface BasicMapper {
    BasicMapper INSTANCE = Mappers.getMapper(BasicMapper.class);
    BasicUserDTO convert(BasicUser user);
    BasicUser convertApi(BasicUserDTO user);
}
