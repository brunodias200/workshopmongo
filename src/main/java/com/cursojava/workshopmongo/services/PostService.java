package com.cursojava.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursojava.workshopmongo.domain.Post;
import com.cursojava.workshopmongo.repository.PostRepository;
import com.cursojava.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto Não Encontrado"));	
	}
	
	public List<Post> findByTitle(String text) {
		return repo.findByTitle(text); // Metodo alternativo utilizando a anotation @Query
		//return repo.findByTitleContainingIgnoreCase(text); // Metodo utilizando metodo padrão do framework spring
		
	}
}
