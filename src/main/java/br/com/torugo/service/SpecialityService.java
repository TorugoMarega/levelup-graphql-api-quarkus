package br.com.torugo.service;
import br.com.torugo.model.Speciality;
import br.com.torugo.model.User;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
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
