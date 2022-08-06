package com.minejava.mapstruct.mapstructservice.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class BasicUserDTO {
    private int id;
    private String name;
}
