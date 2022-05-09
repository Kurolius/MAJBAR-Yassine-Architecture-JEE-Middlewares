package ma.enset.patientmvc;

import ma.enset.patientmvc.entities.Patient;
import ma.enset.patientmvc.repositories.PatientRepository;
import ma.enset.patientmvc.security.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class PatientMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientMvcApplication.class, args);
    }

    @Bean //au démarrage crée moi un PasswordEncoder et tu le place dans context
    BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(new Patient(null,"Majbar",new Date(),false,666));
            patientRepository.save(new Patient(null,"Alaa",new Date(),true,420));
            patientRepository.save(new Patient(null,"Ouajjani",new Date(),false,69));
            patientRepository.save(new Patient(null,"ait el asri",new Date(),true,12));

            patientRepository.findAll().forEach(p->{
                System.out.println(p.getNom());
            });

        };
    }
    @Bean
    CommandLineRunner saveUsers(SecurityService securityService){
        return args ->{
            securityService.saveNewUser("admin","admin","admin");
            securityService.saveNewUser("Majbar","1234","1234");
            securityService.saveNewUser("ouajjani","1234","1234");
            securityService.saveNewUser("alaa","1234","1234");

            securityService.saveNewRole("USER","");
            securityService.saveNewRole("ADMIN","");

            securityService.addRoleToUser("admin","ADMIN");
            securityService.addRoleToUser("admin","USER");
            securityService.addRoleToUser("Majbar","USER");
            securityService.addRoleToUser("ouajjani","USER");
            securityService.addRoleToUser("alaa","USER");


        };
    }
}
