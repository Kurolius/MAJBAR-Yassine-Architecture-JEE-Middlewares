package ma.enset.hopital.service;

import ma.enset.hopital.entities.Consultation;
import ma.enset.hopital.entities.Medecin;
import ma.enset.hopital.entities.Patient;
import ma.enset.hopital.entities.RendezVous;
import ma.enset.hopital.repositories.ConsultationRepository;
import ma.enset.hopital.repositories.MedecinRepository;
import ma.enset.hopital.repositories.PatientRepository;
import ma.enset.hopital.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {
   private PatientRepository patientRepository;
   private MedecinRepository medecinRepository;
   private RendezVousRepository rendezVousRepository;
   private ConsultationRepository consultationRepository;

    public HospitalServiceImpl(PatientRepository patientRepository,
                               MedecinRepository medecinRepository,
                               RendezVousRepository rendezVousRepository,
                               ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {
        //générer une chaine de carac unique car elle prend la date du systéme
        rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
