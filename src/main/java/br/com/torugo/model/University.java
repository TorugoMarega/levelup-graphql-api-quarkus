package br.com.torugo.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class University extends PanacheEntity {

    private String name;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "university")
    private List<Course> courses = new java.util.ArrayList<>();


    public static University findByName(String name){
        return University.find("name",name).firstResult();
    }
}
