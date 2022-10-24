package br.com.levelup.model;

import br.com.levelup.model.Skills.SoftHardSkill;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user_soft_hard_skill")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserSoftHardSkill extends PanacheEntity {

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "skill_id")
    private SoftHardSkill skill;
    private Integer level = 0;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
}
