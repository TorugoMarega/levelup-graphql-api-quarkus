package br.com.torugo.domain;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.smallrye.graphql.api.Nullable;

import javax.persistence.*;

@Entity
@Table(schema = "person")
public class Person extends PanacheEntity {


    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Nullable
    @Column(name = "age")
    private Integer age;

    @Column(name = "cpf")
    private String cpf;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @MapsId
    @PrimaryKeyJoinColumn
    private College college;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }
}
