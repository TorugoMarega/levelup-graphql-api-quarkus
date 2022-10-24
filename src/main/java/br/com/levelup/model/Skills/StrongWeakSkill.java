package br.com.levelup.model.Skills;

import br.com.levelup.model.User;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "strong_and_weak_skill")
@Getter
@Setter
public class StrongWeakSkill extends PanacheEntity {
    private String skill;
    private SkillTypeStrongWeak type;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
