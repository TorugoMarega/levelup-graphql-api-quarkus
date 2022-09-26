package br.com.torugo.service;

import br.com.torugo.domain.College;
import br.com.torugo.domain.Person;
import br.com.torugo.domain.User;
import br.com.torugo.domain.UserMood;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class UserService {

    public List<User> listAllUsers(){
        return User.listAll();
    }

    @Transactional
    public User addUser(User user, Person person){
        user.setPerson(person);
        user.persist();
        return user;
    }

    @Transactional
    public User deleteUser(Long id){
        User updateUser = User.findById(id);
        updateUser.setDeleted(true);
        updateUser.persist();
        return updateUser;
    }

    @Transactional
    public User activateUser(Long id){
        User updateUser = User.findById(id);
        updateUser.setDeleted(false);
        updateUser.persist();
        return updateUser;
    }

    @Transactional
    public User updateUserUsernameColorEmail(User user, Long id){
        User updateUser = User.findById(id);
        if(user.getUsername() != null ){
            updateUser.setUsername(user.getUsername());
        }
        if (user.getColor_hex() != null ) {
            updateUser.setColor_hex(user.getColor_hex());
        }
        if(user.getEmail()!=null){
            updateUser.setEmail(user.getEmail());
        }
        updateUser.persist();
        return updateUser;
    }
}
