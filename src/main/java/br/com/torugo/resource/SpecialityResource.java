package br.com.torugo.resource;

import br.com.torugo.model.Speciality;
import br.com.torugo.model.User;
import br.com.torugo.service.SpecialityService;
import org.eclipse.microprofile.graphql.*;

import javax.inject.Inject;
import java.util.List;

@GraphQLApi
public class SpecialityResource {
    @Inject
    private SpecialityService service;

    @Query
    @Description("Lista todos as Especialidades")
    public List<Speciality> listAllSpecialities(){
        return this.service.listAllSpecialities();
    }

    @Mutation
    @Description("Criar uma nova especialidade e atribuí-lo a um usuário já existente")
    public Speciality addSpeciality(Speciality speciality, @Source(name = "user") User user){
        return this.service.addSpeciality(speciality, user);
    }

    @Mutation
    @Description("Atualizar uma especialidade de um usuário")
    public Speciality updateSpeciality(Speciality speciality, Long id){
        return this.service.updateSpeciality(speciality, id);
    }

    @Mutation
    @Description("Deletar uma especialidade")
    public String deleteSpeciality(Long id){
        return this.service.deleteSpeciality(id);
    }

}
