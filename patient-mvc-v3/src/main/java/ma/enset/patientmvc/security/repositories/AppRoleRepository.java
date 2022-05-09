package ma.enset.patientmvc.security.repositories;

import ma.enset.patientmvc.security.entities.AppRole;
import ma.enset.patientmvc.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole,Long> {
    AppRole findByRoleName(String roleName);
}
