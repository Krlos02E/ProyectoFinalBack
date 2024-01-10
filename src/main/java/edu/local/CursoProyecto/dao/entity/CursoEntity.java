package edu.local.CursoProyecto.dao.entity;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "curso")
public class CursoEntity extends RepresentationModel<CursoEntity> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcurso;
    private Integer ciclo;
    private String nombre;
    private String profesor;
    private String facultad;
    private String modalidad;
    private Double creditos;
    

}
