package ma.enset.studentmvc.repositories;

import ma.enset.studentmvc.entities.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
    Page<Student > findByNomContains(String keyword, Pageable pageable);

}
