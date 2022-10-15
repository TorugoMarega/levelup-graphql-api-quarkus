package br.com.torugo.model.Skills;

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

//    @Column(length = 2)
//    private Integer level = 0;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
//    public void setLevel(Integer level) {
//        if(Integer.parseInt(level.toString()) <= 10 & Integer.parseInt(level.toString()) >= 0  ){
//            this.level = level;
//        }
//    }
//
//    public static List<SoftHardSkill> generateSoftHardSkillList(){
//        List<SoftHardSkill> softHardSkillList = new ArrayList<>();
//
//        SoftHardSkill skill_1 = new SoftHardSkill("Métododologias Ágeis",SkillTypeSoftHard.HARD);
//        softHardSkillList.add(skill_1);
//
//        SoftHardSkill skill_2 = new SoftHardSkill("Pacote Office",SkillTypeSoftHard.HARD);
//        softHardSkillList.add(skill_2);
//
//        SoftHardSkill skill_3 = new SoftHardSkill("Lógica de Programação",SkillTypeSoftHard.HARD);
//        softHardSkillList.add(skill_3);
//
//        SoftHardSkill skill_4 = new SoftHardSkill("Front End",SkillTypeSoftHard.HARD);
//        softHardSkillList.add(skill_4);
//
//        SoftHardSkill skill_5 = new SoftHardSkill("Back End",SkillTypeSoftHard.HARD);
//        softHardSkillList.add(skill_5);
//
//        SoftHardSkill skill_6 = new SoftHardSkill("Empreendedorismo",SkillTypeSoftHard.SOFT);
//        softHardSkillList.add(skill_6);
//
//        SoftHardSkill skill_7 = new SoftHardSkill("Comunicação",SkillTypeSoftHard.SOFT);
//        softHardSkillList.add(skill_7);
//
//        SoftHardSkill skill_8 = new SoftHardSkill("Criatividade e Inovação",SkillTypeSoftHard.SOFT);
//        softHardSkillList.add(skill_8);
//
//        SoftHardSkill skill_9 = new SoftHardSkill("Colaboração",SkillTypeSoftHard.SOFT);
//        softHardSkillList.add(skill_9);
//
//        SoftHardSkill skill_10 = new SoftHardSkill("Planejamento e Organização",SkillTypeSoftHard.SOFT);
//        softHardSkillList.add(skill_10);
//
//        SoftHardSkill skill_11 = new SoftHardSkill("Resolução de Problemas",SkillTypeSoftHard.SOFT);
//        softHardSkillList.add(skill_11);
//
//        //SoftHardSkill.persist(softHardSkillList);
//        return softHardSkillList;
//    }
}
