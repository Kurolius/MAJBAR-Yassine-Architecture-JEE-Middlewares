package ma.enset.jpaenset;

import ma.enset.jpaenset.entities.Role;
import ma.enset.jpaenset.entities.User;
import ma.enset.jpaenset.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class JpaEnsetApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaEnsetApplication.class, args);
    }


    @Bean  //va s'exécuter au démarrage
    CommandLineRunner start(UserService userService){
        return args -> {
            User user = new User();
            user.setUsername("user");
            user.setPassword("user123");
            userService.addNewUser(user);

            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword("admin123");
            userService.addNewUser(admin);

            Stream.of("STUDENT","USER","ADMIN").forEach(r->{
                Role role1 = new Role();
                role1.setRoleName(r);
                userService.addNewRole(role1);
            });

            userService.addRoleToUser("user","STUDENT");
            userService.addRoleToUser("user","USER");
            userService.addRoleToUser("admin","USER");
            userService.addRoleToUser("admin","ADMIN");

            try {
                User authUser = userService.autheticate("user","user123");
                System.out.println(authUser.getUserId());
                System.out.println(authUser.getUsername());
                System.out.println("roles");
                authUser.getRoles().forEach(r->{
                    System.out.println("Role => "+r.toString());
                });
            }catch (Exception e){

            }
        };
    }
}
