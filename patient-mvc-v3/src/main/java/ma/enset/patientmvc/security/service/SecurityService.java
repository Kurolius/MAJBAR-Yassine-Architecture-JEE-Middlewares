package ma.enset.patientmvc.security.service;

import ma.enset.patientmvc.security.entities.AppRole;
import ma.enset.patientmvc.security.entities.AppUser;

public interface SecurityService {
    AppUser saveNewUser(String username,String password, String rePwd);
    AppRole saveNewRole(String roleName, String description);
    void addRoleToUser(String username, String roleName);
    void removeRoleFromUser(String username, String roleName);
    AppUser loadUserByUsername(String username);
}
