package com.jeffersonsilva.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.jeffersonsilva.workshopmongo.domain.User;
import com.jeffersonsilva.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bernardo = new User(null, "Bernardo Kenji", "bernardo@gmail.com");
		User jefferson = new User(null, "Jefferson Silva", "jefferson@gmail.com");
		User murilo = new User(null, "Murilo Abe", "murilo@gmail.com");

		userRepository.saveAll(Arrays.asList(maria, alex, bernardo, jefferson, murilo));
	
	}
}
