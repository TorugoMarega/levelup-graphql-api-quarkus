package br.com.levelup.resource;

import br.com.levelup.model.Hobbie;
import br.com.levelup.model.User;
import br.com.levelup.service.HobbieService;
import org.eclipse.microprofile.graphql.*;

import javax.transaction.Transactional;
import java.util.List;

@GraphQLApi
public class HobbieResource {

    private HobbieService service = new HobbieService();

    @Query
    @Description("Lista todos os Hobbies")
    public List<Hobbie> listAllHobbies(){
        return this.service.listAllHobbies();
    }

    @Mutation
    @Transactional
    @Description("Criar um novo hobbie e atribuí-lo a um usuário já existente")
    public Hobbie addHobbie(Hobbie hobbie, @Source(name = "user") User user){
        return this.service.addHobbie(hobbie, user);
    }

    @Mutation
    @Transactional
    @Description("Atualizar um hobbie de um usuário")
    public Hobbie updateHobbie(Hobbie hobbie,Long id){
        return this.service.updateHobbie(hobbie, id);
    }

    @Mutation
    @Transactional
    @Description("Deletar um hobbie")
    public String deleteHobbie(Long id){
        return this.service.deleteHobbie(id);
    }

}
