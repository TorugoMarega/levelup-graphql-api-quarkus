package br.com.levelup.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "specialities")
@Getter
@Setter
public class Speciality extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String speciality;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
