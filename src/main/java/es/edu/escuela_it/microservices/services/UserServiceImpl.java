package es.edu.escuela_it.microservices.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import es.edu.escuela_it.microservices.model.UserDTO;


@Service
@Qualifier("DB")
public class UserServiceImpl implements UserService{
	
	@Override
	public UserDTO getUserById(Integer id) {
		return new UserDTO(1, "Jose");
	}
}
