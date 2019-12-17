package com.jeffersonsilva.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeffersonsilva.workshopmongo.domain.User;
import com.jeffersonsilva.workshopmongo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	public List<User> findAll() {
		return repo.findAll();
	}
}