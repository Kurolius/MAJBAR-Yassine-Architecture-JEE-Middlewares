package ma.enset.jpaapp;

import ma.enset.jpaapp.entities.Patient;
import ma.enset.jpaapp.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class JpaAppApplication implements CommandLineRunner {

    @Autowired
    PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("------------------------------------------------------------------------------------");

        //initilize datas
        patientRepository.save(new Patient(null,"MAJBAR",new Date(), false,666));
        patientRepository.save(new Patient(null,"ALAA",new Date(), true,69));
        patientRepository.save(new Patient(null,"OUAJJANI",new Date(), false,420));

        // get all Patient data
        List<Patient> patients = patientRepository.findAll();


        // displaying data
        for (Patient p : patients) {
            System.out.println(p.getNom());
            System.out.println(p.getDateNaissance());
            System.out.println(p.isMalade());
            System.out.println(p.getScore());
            System.out.println("###########################");
        }


        // get Patient Malade = False
        List<Patient> byMalade = patientRepository.findByMalade(false);
        System.out.println("------ Patients PAS Malades ------");
        for (Patient p : byMalade) {
            System.out.println(p.getNom());
            System.out.println(p.getDateNaissance());
            System.out.println(p.isMalade());
            System.out.println(p.getScore());
            System.out.println("###########################");
        }


        // get Patient Malade = False
        byMalade = patientRepository.findByMalade(true);
        System.out.println("------ Patients Malades ------");
        for (Patient p : byMalade) {
            System.out.println(p.getNom());
            System.out.println(p.getDateNaissance());
            System.out.println(p.isMalade());
            System.out.println(p.getScore());
            System.out.println("###########################");
        }


        // Using @QUERY
        List<Patient> byDate = patientRepository.FindPatients(new Date(2020,3,1),new Date(2022,3,1),"MAJBAR");
        System.out.println("------ Patients between dates ------");
        for (Patient p : byDate) {
            System.out.println(p.getNom());
            System.out.println(p.getDateNaissance());
            System.out.println(p.isMalade());
            System.out.println(p.getScore());
            System.out.println("###########################");
        }

    }

}
