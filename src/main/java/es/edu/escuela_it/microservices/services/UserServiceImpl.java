package es.edu.escuela_it.microservices.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import es.edu.escuela_it.microservices.model.UserDTO;


@Service
@Qualifier("DB")
@ConditionalOnProperty(prefix = "app", name = "edition", havingValue = "Community")
public class UserServiceImpl implements UserService{
	
	@Override
	public UserDTO getUserById(Integer id) {
		return new UserDTO(1, "Jose");
	}
}
