package br.com.levelup.service;

import br.com.levelup.model.Hobbie;
import br.com.levelup.model.User;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class HobbieService {

    public List<Hobbie> listAllHobbies(){
        return Hobbie.listAll();
    }

    @Transactional
    public Hobbie addHobbie (Hobbie hobbie, User user){
        User updateUser = User.findById(user.id);
        if(updateUser.isPersistent()){
            hobbie.setUser(updateUser);
            hobbie.persist();
        }
        return hobbie;
    }

    @Transactional
    public Hobbie updateHobbie (Hobbie hobbie, Long id){
        Hobbie updateHobbie = Hobbie.findById(id);
        if(updateHobbie.isPersistent()){
            updateHobbie.setHobbie(hobbie.getHobbie());
            updateHobbie.persist();
        }
        return updateHobbie;
    }

    @Transactional
    public String deleteHobbie (Long id){
        Hobbie updateHobbie = Hobbie.findById(id);
        if(updateHobbie.isPersistent()){
            updateHobbie.delete();
        }
        return "Hobbie deleted";
    }
}
