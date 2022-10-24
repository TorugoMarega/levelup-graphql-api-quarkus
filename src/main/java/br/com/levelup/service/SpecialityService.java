package br.com.levelup.service;

import br.com.levelup.model.Speciality;
import br.com.levelup.model.User;

import javax.transaction.Transactional;
import java.util.List;


public class SpecialityService {

    public List<Speciality> listAllSpecialities(){
        return Speciality.listAll();
    }

    @Transactional
    public Speciality addSpeciality (Speciality speciality, User user){
        User updateUser = User.findById(user.id);
        if(updateUser.isPersistent()){
            speciality.setUser(updateUser);
            speciality.persist();
        }
        return speciality;
    }

    @Transactional
    public Speciality updateSpeciality (Speciality speciality, Long id){
        Speciality updateSpeciality = Speciality.findById(id);
        if(updateSpeciality.isPersistent()){
            updateSpeciality.setSpeciality(speciality.getSpeciality());
            updateSpeciality.persist();
        }
        return updateSpeciality;
    }

    @Transactional
    public String deleteSpeciality (Long id){
        Speciality updateSpeciality = Speciality.findById(id);
        if(updateSpeciality.isPersistent()){
            updateSpeciality.delete();
        }
        return "Speciality deleted";
    }
}
