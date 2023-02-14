package com.cursojava.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.cursojava.workshopmongo.domain.User;
import com.cursojava.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria_brown@exemplo.com");
		User alex = new User(null, "Alex Green", "alex_green@exemplo.com");
		User bob = new User(null, "Bob Gray", "bob_gray@exemplo.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
	}
	

}
