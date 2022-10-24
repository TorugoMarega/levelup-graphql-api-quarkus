package br.com.levelup.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "course")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course extends PanacheEntity {
    @ManyToOne
    @JoinColumn(name = "university_id")
    private University university;
    private String name;
    @OneToMany
    @Column(name = "student_college")
    private List<College> studentCollege;


    public static Course findByName(String name){
        return Course.find("name",name).firstResult();
    }
}