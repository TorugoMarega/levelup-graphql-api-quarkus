package br.com.torugo.service;

import br.com.torugo.model.Skills.SoftHardSkill;
import br.com.torugo.model.Skills.StrongWeakSkill;
import br.com.torugo.model.Speciality;
import br.com.torugo.model.User;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class SkillsService {
    //----------------------------- STRONG AND WEAK SKILLS-------------------------------------
    public List<StrongWeakSkill> listAllStrongWeakSkills(){
        return StrongWeakSkill.listAll();
    }

    @Transactional
    public StrongWeakSkill addStrongWeakSkills (StrongWeakSkill skill, User user){
        User updateUser = User.findById(user.id);
        if(updateUser.isPersistent()){
            skill.setUser(updateUser);
            skill.persist();
        }
        return skill;
    }

    @Transactional
    public StrongWeakSkill updateStrongWeakSkill (StrongWeakSkill skill, Long id){
        StrongWeakSkill updateStrongWeakSkill = StrongWeakSkill.findById(id);
        if(updateStrongWeakSkill.isPersistent()){
            if(skill.getSkill() != null ){
                updateStrongWeakSkill.setSkill(updateStrongWeakSkill.getSkill());
            }
            if(skill.getType() != null ){
                updateStrongWeakSkill.setType(updateStrongWeakSkill.getType());
            }
            updateStrongWeakSkill.setSkill(skill.getSkill());
            updateStrongWeakSkill.persist();
        }
        return updateStrongWeakSkill;
    }

    @Transactional
    public String deleteStrongWeakSkill (Long id){
        StrongWeakSkill existentSkill = StrongWeakSkill.findById(id);
        if(existentSkill.isPersistent()){
            existentSkill.delete();
        }
        return "Skill deleted";
    }

    //----------------------------- SOFT AND HARD SKILLS-------------------------------------
    public List<SoftHardSkill> listAllSoftHardSkill(){
        return SoftHardSkill.listAll();
    }
    @Transactional
    public SoftHardSkill addSoftHardSkills (SoftHardSkill skill, User user){
        User updateUser = User.findById(user.id);
        if(updateUser.isPersistent()){
            skill.setUser(updateUser);
            skill.persist();
        }
        return skill;
    }

    @Transactional
    public SoftHardSkill updateSoftHardSkill (SoftHardSkill skill, Long id){
        SoftHardSkill updateSoftHardSkill = SoftHardSkill.findById(id);
        if(updateSoftHardSkill.isPersistent()){
            if(skill.getSkill() != null ){
                updateSoftHardSkill.setSkill(updateSoftHardSkill.getSkill());
            }
            if(skill.getType() != null ){
                updateSoftHardSkill.setType(updateSoftHardSkill.getType());
            }
            if(skill.getLevel() != null ){
                updateSoftHardSkill.setLevel(updateSoftHardSkill.getLevel());
            }
            updateSoftHardSkill.setSkill(skill.getSkill());
            updateSoftHardSkill.persist();
        }
        return updateSoftHardSkill;
    }

    @Transactional
    public String deleteSoftHardSkill (Long id){
        SoftHardSkill existentSkill = SoftHardSkill.findById(id);
        if(existentSkill.isPersistent()){
            existentSkill.delete();
        }
        return "Skill deleted";
    }
}