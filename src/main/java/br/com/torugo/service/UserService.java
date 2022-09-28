package br.com.torugo.service;

import br.com.torugo.model.College;
import br.com.torugo.model.Hobbie;
import br.com.torugo.model.Person;
import br.com.torugo.model.User;

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
        College college = new College();
        person.setCollege(college);
        user.setPerson(person);
        person.persist();
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

    public User findUserById(Long id){
        return User.findById(id);
    }

    public List<User> findByUserName(String username){
        return User.findByUserNameContaining(username);
    }
    public List<User> findByPersonName(String name){
        return User.findByPersonNameContaining(name);
    }

    public List<User> findByDeleted(Boolean deleted){
        return User.findByDeleted(deleted);
    }

}
