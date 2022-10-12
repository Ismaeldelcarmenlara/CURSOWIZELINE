package com.wizeline.maven.learningjava;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wizeline.maven.learningjava.model.ResponseDTO;
import com.wizeline.maven.learningjava.service.UserServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
class LearningjavamavenApplicationTests {

	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@SuppressWarnings("deprecation")
	@Test
	void createUserTest() {
		
		ResponseDTO salida =userServiceImpl.createUser("USER1", "PASS123");
		
		assertEquals("success", salida.getStatus());
	}

}
