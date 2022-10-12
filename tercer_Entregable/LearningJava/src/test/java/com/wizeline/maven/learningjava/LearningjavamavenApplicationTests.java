package com.wizeline.maven.learningjava;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wizeline.maven.learningjava.service.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class LearningjavamavenApplicationTests {

	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Test
	void createUserTest() {
		
		userServiceImpl.createUser(null, null);
	}

}
