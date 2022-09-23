package br.com.torugo.service;

import br.com.torugo.domain.Person;
import br.com.torugo.domain.User;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class UserService {

    public List<User> listAllUsers(){
        return User.listAll();
    }

    @Transactional
    public User addUser(User user, Person person){
        //person.persist();
        user.setPerson(person);
        user.persist();
        System.out.println("CHEGOU NO SERVICE");
        return user;
    }


}
