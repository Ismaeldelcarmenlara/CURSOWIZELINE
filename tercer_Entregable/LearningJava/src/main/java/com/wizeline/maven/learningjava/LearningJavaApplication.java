package com.wizeline.maven.learningjava;

//EnableKafka en SpringBootApplication
import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;

import com.wizeline.maven.learningjava.service.UserService;
import com.wizeline.maven.learningjava.service.UserServiceImpl;


@SpringBootApplication
@EnableFeignClients
@EnableKafka
public class LearningJavaApplication {

@Bean
public static UserService userService() {
return new UserServiceImpl();
}
	
	
	public static void main(String[] args) throws IOException {
		SpringApplication.run(LearningJavaApplication.class, args);
	}

}
