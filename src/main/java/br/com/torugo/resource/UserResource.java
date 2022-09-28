package br.com.torugo.resource;

import br.com.torugo.model.Hobbie;
import br.com.torugo.model.Person;
import br.com.torugo.model.User;
import br.com.torugo.service.UserService;
import org.eclipse.microprofile.graphql.*;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@GraphQLApi
public class UserResource {
    @Inject
    private UserService service;


    @Mutation
    @Description("Salva no banco de dados uma entidade do tipo Usuario e outra do tipo Pessoa que se refere ao usuário")
    public User addUser(User user,@Source Person person){
        return this.service.addUser(user, person);
    }

    @Mutation
    @Description("Atualiza o campo Deleted como TRUE no Usuario escolhido pelo ID")
    public User deleteUser(@Name("id") Long id){
        return this.service.deleteUser(id);
    }

    @Mutation
    @Description("Atualiza o campo Deleted como FALSE no Usuario escolhido pelo ID")
    public User activateUser(@Name("id") Long id){
        return this.service.activateUser(id);
    }

    @Mutation
    @Description("Pode atualizar os campos (username, color_hex e email) do Usuario")
    public User updateUserUsernameColorEmail(User user, @Name("id") Long id){
        return this.service.updateUserUsernameColorEmail(user, id);
    }

    @Query
    @Description("Encontra usuário específico pelo ID")
    public User findUserById(@Name("id") Long id){
        return this.service.findUserById(id);
    }

    @Query
    @Name("listAllUsers")
    @Description("Retorna a lista com todos os usuarios")
    public List<User> listAllUsers(){
        return this.service.listAllUsers();
    }
    @Query
    @Description("Retorna lista de usuários com determinado USERNAME")
    public List<User> findByUserName(@Name("username") String username){
        return this.service.findByUserName(username);
    }

    @Query
    @Description("Retorna lista de usuários com determinado Nome ou Sobrenome")
    public List<User> findByPersonName (@Name("name") String name){
        return this.service.findByPersonName(name);
    }

    @Query
    @Description("Retorna lista de usuários ativos ou inativos")
    public List<User> findByDeleted (@Name("deleted") Boolean deleted){
        return this.service.findByDeleted(deleted);
    }

}


