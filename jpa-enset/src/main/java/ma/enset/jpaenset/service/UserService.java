package ma.enset.jpaenset.service;

import ma.enset.jpaenset.entities.Role;
import ma.enset.jpaenset.entities.User;

import java.util.List;

public interface UserService {
    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUserName(String userName);
    Role findRoleByRoleNAme(String roleNAme);
    void addRoleToUser(String username, String rolename);
    User autheticate(String username,String password);
    List<User> getAllUsers();
}
