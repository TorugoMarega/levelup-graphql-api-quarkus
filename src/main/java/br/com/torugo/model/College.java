package br.com.torugo.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "college")
@Getter
@Setter
public class College extends PanacheEntity {

    private String course;
    private String university;
    private String period;

}
