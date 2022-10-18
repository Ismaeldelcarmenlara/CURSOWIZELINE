package com.wizeline.maven.learningjavamaven.CRUDtests;

import static com.wizeline.maven.learningjavamaven.utils.Utils.getCountry;
import static com.wizeline.maven.learningjavamaven.utils.Utils.pickRandomAccountType;
import static com.wizeline.maven.learningjavamaven.utils.Utils.randomBalance;
import static com.wizeline.maven.learningjavamaven.utils.Utils.randomInt;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.wizeline.maven.learningjavamaven.enums.Country;
import com.wizeline.maven.learningjavamaven.model.BankAccountDTO;
import com.wizeline.maven.learningjavamaven.repository.RepositorioTest;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestPropertySource(properties = "spring.mongodb.embedded.version=3.5.5")

public class OperacionesCrudTest {

	private static final Logger LOG = Logger.getLogger(OperacionesCrudTest.class.getName());

	private String user = null;
	private String password = null;
	private String fecha = null;

	@Mock
	private BankAccountDTO bankAccountOne;

	@Autowired
	RepositorioTest repositorioTest;

	@Spy
	List<BankAccountDTO> listaDatos = new ArrayList<>();

	
}