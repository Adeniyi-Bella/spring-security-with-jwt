package java.techie.userservice.service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.techie.userservice.User.RoleRepo;
import java.techie.userservice.User.UserRepo;
import java.techie.userservice.domain.Role;
import java.techie.userservice.domain.User;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService{
    private final RoleRepo roleRepo;
    private final UserRepo userRepo;
    @Override
    public User saveUser(User user) {
        log.info("Saving new user {} to the DB", user.getName());
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to the DB", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role {} to user {}", roleName, username);
        User user = userRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);
        if(user != null && role != null) {
            user.getRoles().add(role);
            //no need for the code below as the transactional annotation saves it to the DB
            //userRepo.save(user);
        }
    }

    @Override
    public User getUser(String username) {
        log.info("Fetching user {}",username);
        return userRepo.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching all users");
        return userRepo.findAll();
    }
}
