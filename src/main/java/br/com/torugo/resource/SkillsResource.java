package br.com.torugo.resource;

import br.com.torugo.model.Skills.SoftHardSkill;
import br.com.torugo.model.Skills.StrongWeakSkill;
import br.com.torugo.model.User;
import br.com.torugo.service.SkillsService;
import org.eclipse.microprofile.graphql.*;

import javax.inject.Inject;
import java.util.List;

@GraphQLApi
public class SkillsResource {

    private SkillsService service;
    //----------------------------- STRONG AND WEAK SKILLS-------------------------------------

    @Query
    @Description("Lista todas as Competencias Fortes e Fracas")
    public List<StrongWeakSkill> listAllStrongWeakSkills(){
        return this.service.listAllStrongWeakSkills();
    }

    @Mutation
    @Description("Criar uma nova Competência Forte ou Fraca e atribuí-la a um usuário já existente")
    public StrongWeakSkill addStrongWeakSkills(StrongWeakSkill skill, @Source(name = "user") User user){
        return this.service.addStrongWeakSkills(skill, user);
    }

    @Mutation
    @Description("Atualiza uma Competência Forte ou Fraca")
    public StrongWeakSkill updateStrongWeakSkills(StrongWeakSkill skill, @Source(name = "id") Long id){
        return this.service.updateStrongWeakSkill(skill, id);
    }

    @Mutation
    @Description("Deleta uma Competência Forte ou Fraca")
    public String deleteStrongWeakSkills(@Source(name = "id") Long id){
        return this.service.deleteStrongWeakSkill(id);
    }

    //----------------------------- SOFT AND HARD SKILLS-------------------------------------

    @Query
    @Description("Lista todas as Competencias Tenicas e Comportamentais (Hard e Soft Skills)")
    public List<SoftHardSkill> listAllSoftHardSkill(){
        return this.service.listAllSoftHardSkill();
    }
    @Mutation
    @Description("Criar uma nova Competência Técnica ou Comportamental e atribuí-la a um usuário já existente")
    public SoftHardSkill addSoftHardSkill(SoftHardSkill skill, @Source(name = "user") User user){
        return this.service.addSoftHardSkills(skill, user);
    }

    @Mutation
    @Description("Atualiza uma Competência Forte ou Fraca")
    public SoftHardSkill updateSoftHardSkill(SoftHardSkill skill, @Source(name = "id") Long id){
        return this.service.updateSoftHardSkill(skill, id);
    }

    @Mutation
    @Description("Deleta uma Competência Forte ou Fraca")
    public String deleteSoftHardSkill(@Source(name = "id") Long id){
        return this.service.deleteSoftHardSkill(id);
    }

}
