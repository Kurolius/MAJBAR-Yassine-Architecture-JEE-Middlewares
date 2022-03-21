package ma.enset.ormjpahibernatespringdata.repositories;

import ma.enset.ormjpahibernatespringdata.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

//Spring data
public interface PatientRepository extends JpaRepository <Patient,Long>{
    //select * from patient where malade = m;
    List<Patient> findByMalade(boolean m);

    //retourne les personnes malades et la page (numero et size)
    Page<Patient> findByMalade(boolean m, Pageable pageable);

    List<Patient> findByMaladeAndScoreLessThan(boolean m ,int score);

    List<Patient> findByMaladeIsTrueAndScoreLessThan(int score);

    List<Patient> findByDateNaissanceBetween(Date d1, Date d2);

    List<Patient> findByDateNaissanceBetweenAndMaladeIsTrueOrNomLike(Date d1, Date d2,String keyword);

    //une autre façon de récupération des données grace à HQL
    @Query("select p from Patient p where p.dateNaissance between :x and :y or p.nom like :z")
    List<Patient> chercherPatients(@Param("x") Date d1, @Param("y") Date d2,@Param("z") String keyword);

    @Query("select p from Patient p where p.nom like :x and p.score < :y")
    List<Patient> chercherPatients(@Param("x") String keyword, @Param("y") int scoreMin );
}
