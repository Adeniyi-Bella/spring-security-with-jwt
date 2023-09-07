package bella.techie.userservice;

import bella.techie.userservice.domain.Role;
import bella.techie.userservice.domain.User;
import bella.techie.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return arg -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "John Travolta", "john1", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "John 2", "john2", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "John 3", "john3", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "John 4", "john4", "1234", new ArrayList<>()));

			userService.addRoleToUser("john1", "ROLE_USER");
			userService.addRoleToUser("john1", "ROLE_MANAGER");
			userService.addRoleToUser("john2", "ROLE_ADMIN");
			userService.addRoleToUser("john3", "ROLE_USER");
			userService.addRoleToUser("john", "ROLE_SUPER_ADMIN");

		};
	}

}
