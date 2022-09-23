package br.com.torugo.service;

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
        //person.persist();
        user.setPerson(person);
        user.persist();
        System.out.println("CHEGOU NO SERVICE");
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
    @Transactional
    public User updateUserMood(Long id, UserMood userMood) {
        User updateUserMood = User.findById(id);
        updateUserMood.setUserMood(userMood);
        updateUserMood.persist();
        return updateUserMood;
    }

    public List<String> listAllMood(){
        List<String> moodList = new ArrayList<>();
        moodList.add(UserMood.ESTRESSADO.toString());
        moodList.add(UserMood.TRISTE.toString());
        moodList.add(UserMood.OCUPADO.toString());
        moodList.add(UserMood.FELIZ.toString());
        moodList.add(UserMood.TRANSCENDENDO.toString());
        moodList.add(UserMood.FRIO.toString());
        moodList.add(UserMood.CALOR.toString());
        moodList.add(UserMood.BADASS.toString());
        moodList.add(UserMood.NEUTRO.toString());
        return moodList;
    }
}
