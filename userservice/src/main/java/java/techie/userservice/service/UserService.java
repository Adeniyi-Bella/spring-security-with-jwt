package java.techie.userservice.service;

import java.techie.userservice.domain.Role;
import java.techie.userservice.domain.User;
import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
