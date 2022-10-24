package br.com.levelup.resource;

import br.com.levelup.model.College;
import br.com.levelup.model.Login;
import br.com.levelup.model.User;
import br.com.levelup.service.LoginService;
import br.com.levelup.service.UserService;
import org.eclipse.microprofile.graphql.*;

import javax.transaction.Transactional;
import java.util.List;

@GraphQLApi
public class UserResource {

    UserService service = new UserService();
    LoginService loginService = new LoginService();


    @Mutation
    @Transactional
    @Description("Salva no banco de dados uma entidade do tipo Usuario e outra do tipo Pessoa que se refere ao usuário")
    public User addUser(User user){
        return this.service.addUser(user);
    }

    @Mutation
    @Transactional
    @Description("Atualiza o campo Deleted como TRUE no Usuario escolhido pelo ID")
    public User deleteUser(@Name("id") Long id){
        return this.service.deleteUser(id);
    }

    @Mutation
    @Transactional
    @Description("Atualiza o campo Deleted como FALSE no Usuario escolhido pelo ID")
    public User activateUser(@Name("id") Long id){
        return this.service.activateUser(id);
    }

    @Mutation
    @Transactional
    @Description("Pode atualizar os campos (first_name, last_name,username, color_hex e email) do Usuario")
    public User updateUserBasicInformation(User user, Long id){
        return this.service.updateUserBasicInformation(user, id);
    }

    @Mutation
    @Transactional
    @Description("Pode atualizar o campo (Course) do Usuario")
    public User updateUserCollegeInformation (Long userId, College college){
        return this.service.updateUserCollegeInformation(userId, college);
    }

    @Mutation
    @Transactional
    @Description("Deleta campo College do User")
    public String deleteUserCollege (Long userId){
       User user =  User.findById(userId);
       user.getCollegeInformation().delete();
       return "Deleted";
    }
//    @Mutation
//    @Transactional
//    public User updateUser(User user, @Name("id") Long id){
//        return this.service.updateUser(user, id);
//    }

    @Query
    @Name("listAllUsers")
    @Description("Retorna a lista com todos os usuarios")
    public List<User> listAllUsers(){
        return this.service.listAllUsers();
    }

    //--------------------------------- LOGIN ------------------------------------
    @Mutation
    @Transactional
    public String login(Login login){
        return this.loginService.login(login);
    }


    //----------------------------------- FILTERS -------------------------------------------



    @Query
    @Description("Retorna lista de usuários com determinado USERNAME")
    public List<User> findByUserName(@Name("username") String username){
        return this.service.findByUserName(username);
    }

    @Query
    @Description("Encontra usuário específico pelo ID")
    public User findUserById(@Name("id") Long id){
        return this.service.findUserById(id);
    }

//    @Query
//    @Description("Retorna lista de usuários com determinado Nome ou Sobrenome")
//    public List<User> findByPersonName (@Name("name") String name){
//        return this.service.findByPersonName(name);
//    }

    @Query
    @Description("Retorna lista de usuários ativos ou inativos")
    public List<User> findByDeleted (@Name("deleted") Boolean deleted){
        return this.service.findByDeleted(deleted);
    }

}


