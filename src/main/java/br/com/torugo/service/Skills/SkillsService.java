package br.com.torugo.service.Skills;

import br.com.torugo.model.Skills.StrongWeakSkill;
import br.com.torugo.model.Speciality;
import br.com.torugo.model.User;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class SkillsService {

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
        StrongWeakSkill updateStrongWeakSkill = Speciality.findById(id);
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
}
