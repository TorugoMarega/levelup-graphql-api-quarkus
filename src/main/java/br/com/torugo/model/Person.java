package br.com.torugo.model;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "person")
@Getter
@Setter
public class Person extends PanacheEntity {


    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "birthdate")
    @JsonbDateFormat(value = "dd/MM/yyyy", locale = "pt,br")
    private LocalDate birthdate;

    @Column(name = "cpf")
    private String cpf;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @MapsId
    @PrimaryKeyJoinColumn
    private College college=null;

}
