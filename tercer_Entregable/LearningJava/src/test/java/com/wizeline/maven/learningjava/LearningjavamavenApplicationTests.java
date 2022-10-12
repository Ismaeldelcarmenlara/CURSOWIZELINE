package com.wizeline.maven.learningjava;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wizeline.maven.learningjava.model.ResponseDTO;
import com.wizeline.maven.learningjava.service.UserServiceImpl;

@Mock
ResponseEntity<ResponseDTO> responseService;

@Mock
ResponseEntity<List<ResponseDTO>> responseServices;

@Mock
UserDTO userDTO;

@Mock
List<UserDTO> userDTOList;

@Autowired
private UserController userController;

@RunWith(SpringRunner.class)
@SpringBootTest
class LearningjavamavenApplicationTests {

	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@SuppressWarnings("deprecation")
	@Test
	void createUserTest() {
		
		ResponseDTO salida =userServiceImpl.createUser("user2@wizeline.com", "pass2");
		
		assertEquals("success", salida.getStatus());
	}
	
	
	
	@BeforeEach
	void antesDeCadaPrueba() {

		if (user == null && password == null) {

			user = "user2@wizeline.com";
			password = "pass2";

		}

	}
	
	
	@Test
	@DisplayName("PruebaServicioCreateUser")
	public void pruebaServicioCreateUserTest() {
		// {"user":"user2@wizeline.com","password":"pass2"}
		LOG.info("LearningJava - Iniciado servicio REST para servicio /createUser");

		userDTO.setUser(user);
		userDTO.setPassword(password);

		responseService = userController.createUserAccount(userDTO);

		assertEquals(HttpStatus.OK, responseService.getStatusCode());

	}
	
	


Test
@DisplayName("PruebaServicioCreateUsers")
public void pruebaServicioCreateUsersTest() {
	
	LOG.info("LearningJava - Iniciado servicio REST para servicio para crear usuario");
	int repeticiones = 2;
	for (int i = 0; i <= repeticiones; i++) {

		if (i == 1) {
			userDTO.setUser("user2@wizeline.com");
			userDTO.setPassword("pass2");
			userDTOList.add(userDTO);
			responseServices = userController.createUsersAccount(userDTOList);

			assertEquals(HttpStatus.OK, responseServices.getStatusCode());

		} else {
			userDTO.setUser(user);
			userDTO.setPassword(password);
		}

		userDTOList.add(userDTO);

	}

}


@Test
@DisplayName("PruebaServicioLogin")
public void pruebaServicioLoginTest() {

	LOG.info("LearningJava - Iniciado servicio REST / proceso exitoso");

	responseService = userController.loginUser(user, password);
	codigoServicio = responseService.getStatusCodeValue();

	LOG.info("RESULTADO SERVICIO: " + responseService.getStatusCodeValue());
	assertNotNull(codigoServicio);

}



@Test
@DisplayName(" prueba happy path")
public void procesaHappyPathTest() {

	// ?user=user2@wizeline.com&password=pass2

	LOG.info("LearningJava - Iniciado servicio REST para happy path");

	responseService = userController.loginUser(user, password);
	codigoServicio = responseService.getStatusCodeValue();

	LOG.info("RESULTADO SERVICIO: " + responseService.getStatusCodeValue());
	assertEquals(codigoServicio, 200);

}





	

}
