package br.com.levelup.resource;

import br.com.levelup.model.Speciality;
import br.com.levelup.model.User;
import br.com.levelup.service.SpecialityService;
import org.eclipse.microprofile.graphql.*;

import javax.transaction.Transactional;
import java.util.List;

@GraphQLApi
public class SpecialityResource {

    private SpecialityService service = new SpecialityService();

    @Query
    @Description("Lista todos as Especialidades")
    public List<Speciality> listAllSpecialities(){
        return this.service.listAllSpecialities();
    }

    @Mutation
    @Transactional
    @Description("Criar uma nova especialidade e atribuí-lo a um usuário já existente")
    public Speciality addSpeciality(Speciality speciality, @Source(name = "user") User user){
        return this.service.addSpeciality(speciality, user);
    }

    @Mutation
    @Transactional
    @Description("Atualizar uma especialidade de um usuário")
    public Speciality updateSpeciality(Speciality speciality, Long id){
        return this.service.updateSpeciality(speciality, id);
    }

    @Mutation
    @Transactional
    @Description("Deletar uma especialidade")
    public String deleteSpeciality(Long id){
        return this.service.deleteSpeciality(id);
    }

}
