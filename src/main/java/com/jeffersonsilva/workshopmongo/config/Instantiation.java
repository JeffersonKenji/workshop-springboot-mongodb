package com.jeffersonsilva.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.jeffersonsilva.workshopmongo.domain.Post;
import com.jeffersonsilva.workshopmongo.domain.User;
import com.jeffersonsilva.workshopmongo.repository.PostRepository;
import com.jeffersonsilva.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bernardo = new User(null, "Bernardo Kenji", "bernardo@gmail.com");
		User jefferson = new User(null, "Jefferson Silva", "jefferson@gmail.com");
		User murilo = new User(null, "Murilo Abe", "murilo@gmail.com");
		
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", maria);
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", maria);
		
		
		userRepository.saveAll(Arrays.asList(maria, alex, bernardo, jefferson, murilo));
		postRepository.saveAll(Arrays.asList(post1, post2));
	}
}
