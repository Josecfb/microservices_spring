package es.edu.escuela_it.microservices.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import es.edu.escuela_it.microservices.model.UserDTO;

@Primary
@Service
@Qualifier("CLOUD")
public class UserServiceCloudImpl implements UserService{

	@Override
	public UserDTO getUserById(Integer id) {
		// TODO Auto-generated method stub
		return new UserDTO(2, "Paco");
	}

}
