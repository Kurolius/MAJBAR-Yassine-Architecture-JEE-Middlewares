package ma.enset.hopital;

import ma.enset.hopital.entities.*;
import ma.enset.hopital.repositories.ConsultationRepository;
import ma.enset.hopital.repositories.MedecinRepository;
import ma.enset.hopital.repositories.PatientRepository;
import ma.enset.hopital.repositories.RendezVousRepository;
import ma.enset.hopital.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HopitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(HopitalApplication.class, args);
    }
    @Bean
    CommandLineRunner start(IHospitalService hospitalService,
                            PatientRepository patientRepository,
                            RendezVousRepository rendezVousRepository,
                            ConsultationRepository consultationRepository,
                            MedecinRepository medecinRepository){
        return args -> {
            //tous le code ici va s'exécuter au démarrage
            Stream.of("Mohammed","Naoufal","Mehdi")
                    .forEach(name ->{
                        Patient patient = new Patient();
                        patient.setNom(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(false);
                        hospitalService.savePatient(patient);
                    });
            Stream.of("Yassine","Nasser","Aymane")
                    .forEach(name ->{
                        Medecin medecin = new Medecin();
                        medecin.setNom(name);
                        medecin.setEmail(name+"@gmail.com");
                        medecin.setSpecialite(Math.random()>0.5?"Cardio":"chirurgie");
                        hospitalService.saveMedecin(medecin);
                    });

            Patient patient = patientRepository.findById(1L).orElse(null);
            Patient patient1 = patientRepository.findByNom("Mohammed");

            Medecin medecin = medecinRepository.findByNom("Yassine");

            RendezVous rendezVous = new RendezVous();
            rendezVous.setDateCreation(new Date());
            rendezVous.setStatus(StatusRDV.CANCELED);
            rendezVous.setPatient(patient);
            rendezVous.setMedecin(medecin);
            RendezVous savedRDV = hospitalService.saveRendezVous(rendezVous);
            System.out.println(savedRDV.getId());

            RendezVous rendezVous1 = rendezVousRepository.findAll().get(0);
            Consultation consultation = new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapportConsultation("rapport...");
            hospitalService.saveConsultation(consultation);
        };
    }

}
