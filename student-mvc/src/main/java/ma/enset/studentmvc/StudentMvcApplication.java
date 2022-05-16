package ma.enset.studentmvc;

import ma.enset.studentmvc.security.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class StudentMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentMvcApplication.class, args);
    }

    @Bean
        //au démarrage crée moi un PasswordEncoder et tu le place dans context
    BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //@Bean
    CommandLineRunner saveUsers(SecurityService securityService){
        return args ->{
            securityService.saveNewUser("majbar","66669","66669");
            securityService.saveNewUser("admin","admin","admin");
            securityService.saveNewUser("user","user","user");

            securityService.saveNewRole("USER","");
            securityService.saveNewRole("ADMIN","");

            securityService.addRoleToUser("majbar","USER");
            securityService.addRoleToUser("majbar","ADMIN");
            securityService.addRoleToUser("user","USER");
            securityService.addRoleToUser("admin","USER");
            securityService.addRoleToUser("admin","ADMIN");


        };
    }

}
