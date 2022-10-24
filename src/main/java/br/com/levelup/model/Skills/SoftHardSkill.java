package br.com.levelup.model.Skills;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "soft_and_hard_skill")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SoftHardSkill extends PanacheEntity {
    private String skill;
    private SkillTypeSoftHard type;
}
