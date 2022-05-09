package ma.enset.patientmvc.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data @NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 3,max = 30,message = "La taille du nom doit etre entre 3 et 30 caractéres")
    private String nom;
    //@Temporal(TemporalType.DATE)
    @NotNull
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private Date dateNaissance;
    private boolean malade;
    @NotNull
    @DecimalMin("0")
    private int score;
}
