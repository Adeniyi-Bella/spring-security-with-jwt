package java.techie.userservice.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.techie.userservice.domain.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
