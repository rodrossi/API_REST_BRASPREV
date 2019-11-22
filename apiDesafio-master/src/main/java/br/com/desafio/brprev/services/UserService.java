package br.com.desafio.brprev.services;

import br.com.desafio.brprev.entity.User;

public interface UserService {
	
	public User findUserByEmail(String email) ;
	public User saveUser(User user);
	
}
