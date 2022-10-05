package br.com.torugo.model;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.smallrye.graphql.api.Nullable;
import lombok.Getter;
import lombok.Setter;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.*;
import javax.validation.constraints.Null;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "person")
@Getter
@Setter
public class Person extends PanacheEntity {



}
