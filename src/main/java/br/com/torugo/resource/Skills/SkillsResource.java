package br.com.torugo.resource.Skills;

import br.com.torugo.model.Skills.StrongWeakSkill;
import br.com.torugo.model.Speciality;
import br.com.torugo.model.User;
import br.com.torugo.service.Skills.SkillsService;
import br.com.torugo.service.SpecialityService;
import org.eclipse.microprofile.graphql.*;

import javax.inject.Inject;
import java.util.List;

@GraphQLApi
public class SkillsResource {
    @Inject
    private SkillsService service;

    @Query
    @Description("Lista todas as Competencias Fortes e Fracas")
    public List<StrongWeakSkill> listAllStrongWeakSkills(){
        return this.service.listAllStrongWeakSkills();
    }

    @Mutation
    @Description("Criar uma nova especialidade e atribuí-lo a um usuário já existente")
    public StrongWeakSkill addStrongWeakSkills(StrongWeakSkill skill, @Source(name = "user") User user){
        return this.service.addStrongWeakSkills(skill, user);
    }

//
//    @Mutation
//    @Description("Atualizar uma especialidade de um usuário")
//    public Speciality updateSpeciality(Speciality speciality, Long id){
//        return this.service.updateSpeciality(speciality, id);
//    }
//
//    @Mutation
//    @Description("Deletar uma especialidade")
//    public String deleteSpeciality(Long id){
//        return this.service.deleteSpeciality(id);
//    }

}
