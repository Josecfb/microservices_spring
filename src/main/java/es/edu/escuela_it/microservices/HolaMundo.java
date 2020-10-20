//package es.edu.escuela_it.microservices;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import es.edu.escuela_it.microservices.configuration.ApplicationConfig;
//
//@RestController
//public class HolaMundo {
//	@Autowired
//	private ApplicationConfig appConf;
//
//	@GetMapping("/hola")
//	public String saludo() {
//		System.out.println(appConf.toString()+", "+appConf.getJav());
//		return "Hola mundo";
//	}
//}
