package com.minejava.mapstruct.mapstructservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.minejava.mapstruct.mapstructservice.dto.BasicUserDTO;
import com.minejava.mapstruct.mapstructservice.mapper.BasicMapper;
import com.minejava.mapstruct.mapstructservice.model.BasicUser;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

@SpringBootTest
class MapstructServiceApplicationTests {

	BasicUser basicUser;
	BasicMapper mapper = BasicMapper.INSTANCE;

	BasicUserDTO basicUserDTO;


	BasicUserDTO calledBasicUser() {
		basicUser = BasicUser.builder()
		         .id(1)
				 .name("jOHNdOE")
				 .build();

		return mapper.convert(basicUser);

	}
	BasicUser entity = mapper.convertApi(calledBasicUser());


	@Test
	void mapperTests() {
		assertEquals(calledBasicUser().getName(), entity.getName());
		assertEquals(calledBasicUser().getId(), entity.getId());
	}


}
