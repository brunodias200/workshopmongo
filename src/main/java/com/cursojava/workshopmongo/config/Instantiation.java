package com.cursojava.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.cursojava.workshopmongo.domain.Post;
import com.cursojava.workshopmongo.domain.User;
import com.cursojava.workshopmongo.dto.AuthorDTO;
import com.cursojava.workshopmongo.repository.PostRepository;
import com.cursojava.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
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
		
		User maria = new User(null, "Maria Brown", "maria_brown@exemplo.com");
		User alex = new User(null, "Alex Green", "alex_green@exemplo.com");
		User bob = new User(null, "Bob Gray", "bob_gray@exemplo.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null,sdf.parse("21/03/2018"),"Partiu viagem!","Vou viajar para São Paulo",new AuthorDTO(maria));
		Post post2 = new Post(null,sdf.parse("23/03/2018"),"Bom Dias!","Acordei Feliz Hoje!", new AuthorDTO(maria));
			
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
	}
	

}
