package br.com.torugo.model;

import br.com.torugo.model.Skills.SoftHardSkill;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserSofHardSkill extends PanacheEntity {

    @ManyToOne
    @JoinColumn(name = "skill_id")
    private SoftHardSkill skill;
    private Integer level = 0;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

//    public void setLevel(Integer level) {
//        if(Integer.parseInt(level.toString()) <= 10 & Integer.parseInt(level.toString()) >= 0  ){
//            this.level = level;
//        }
//    }
}
