package es.edu.escuela_it.microservices;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


import es.edu.escuela_it.microservices.model.AccountDTO;
import es.edu.escuela_it.microservices.model.UserDTO;

@RestController
@RequestMapping("/users")
public class UsersControllerRest {
	
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable Integer id) {
		System.out.println("Usuario recuperado");
		UserDTO userDTO=new UserDTO(1,"Jose");
		userDTO.setLastName("Fernandez");
		userDTO.setEdad(44);
		
		Link withSelfRel =
				linkTo(methodOn(UsersControllerRest.class).getUserById(userDTO.getId())).withSelfRel();
				userDTO.add(withSelfRel);
		
		return ResponseEntity.ok(userDTO);
	}
	
	@GetMapping
	public ResponseEntity<CollectionModel<UserDTO>> listAllUsers(@RequestParam(required = false) String name,
									  @RequestParam(required = false) String lastName,
									  @RequestParam(required = false) Integer age){
		List<UserDTO> list=List.of(new UserDTO(1, "Jose"),
								   new UserDTO(2, "Juan"),
								   new UserDTO(3, "Antonio"));
		if (name!=null)
			list=list.stream().filter(u->u.getName().contains(name)).collect(Collectors.toList());
		
		for (UserDTO userDTO : list) {
			Link withSelfRel=linkTo(methodOn(UsersControllerRest.class).getUserById(userDTO.getId())).withSelfRel();
			userDTO.add(withSelfRel);
			Link accountsRel=linkTo(methodOn(UsersControllerRest.class).getUserAccounts(userDTO.getId())).withRel("accounts");
			userDTO.add(accountsRel);
		}
		
		Link link=linkTo(methodOn(UsersControllerRest.class).listAllUsers(name, "", 0)).withSelfRel();
		CollectionModel<UserDTO> result=CollectionModel.of(list,link);
		return ResponseEntity.ok(result);
	}
	
	@PostMapping
	public ResponseEntity<String> createUser(@Valid @RequestBody UserDTO userDTO) {
		System.out.println("Creando usuario"+userDTO.getName());
		URI location=ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(userDTO.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO) {
		System.out.println("Actualizando usuario");
		System.out.println(userDTO);
		return ResponseEntity.ok(userDTO);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
		System.out.println("eliminando usuario "+id);
		return ResponseEntity.ok(null); 
	}
	
	@GetMapping("/{id}/accounts")
	public ResponseEntity<List<AccountDTO>> getUserAccounts(@PathVariable Integer id){
		List<AccountDTO> list=List.of(new AccountDTO("google"),new AccountDTO("twiter"),new AccountDTO("escuelait"));
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{id}/accounts/{idAccount}")
	public ResponseEntity<AccountDTO> getUserAccount(@PathVariable Integer id, @PathVariable Integer idAccount){
		
		return ResponseEntity.ok(new AccountDTO("google"));
	}
}
