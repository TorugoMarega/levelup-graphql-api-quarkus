package br.com.levelup.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class Login extends PanacheEntity {
    String nome;
    String senha;

    public Login() {
    }


}
