package br.com.torugo.service;

import br.com.torugo.model.College;
import br.com.torugo.model.Course;
import br.com.torugo.model.Person;
import br.com.torugo.model.Skills.SoftHardSkill;
import br.com.torugo.model.User;
import io.quarkus.hibernate.orm.panache.Panache;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.DynamicUpdate;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;


@ApplicationScoped
public class UserService {


    public List<User> listAllUsers(){
        return User.listAll();
    }

    @Transactional
    public User addUser(User user){
        College college = new College();
        List<SoftHardSkill> softHardSkillList = SoftHardSkill.generateSoftHardSkillList();
        SoftHardSkill.persist(softHardSkillList);
        user.setSoftHardSkills(softHardSkillList);
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
    public User updateUserCollegeInformation(Long userId, Long courseId) {
        User entity = User.findById(userId);
        if(courseId != null ){
            Course course = Course.findById(courseId);
            entity.setCourse(course);
        }
        return entity;
    }

    @Transactional
    public User updateUserBasicInformation(User user, Long id){
        User updateUser = User.findById(id);
        if(user.getFirst_name() != null ){
            updateUser.setFirst_name(user.getFirst_name());
        }
        if(user.getLast_name() != null ){
            updateUser.setLast_name(user.getLast_name());
        }
        if(user.getCpf() != null ){
            updateUser.setCpf(user.getCpf());
        }
        if(user.getUsername() != null ){
            updateUser.setUsername(user.getUsername());
        }
        if (user.getColor_hex() != null ) {
            updateUser.setColor_hex(user.getColor_hex());
        }
        if(user.getEmail()!=null){
            updateUser.setEmail(user.getEmail());
        }
        return updateUser;
    }

    //--------------------------------- FILTROS --------------------------------
    public User findUserById(Long id){
        return User.findById(id);
    }

    public List<User> findByUserName(String username){
        return User.findByUserNameContaining(username);
    }
//    public List<User> findByPersonName(String name){
//        return User.findByPersonNameContaining(name);
//    }

    public List<User> findByDeleted(Boolean deleted){
        return User.findByDeleted(deleted);
    }



    //--------------------------------- ATUALIZA SENHA --------------------------------
    @Transactional
    public String updatePassWord (Long id, String newPassword){
        User user = User.findById(id);
        String oldPassword = user.getPassword_hash();
        if(!Objects.equals(newPassword, oldPassword) & newPassword != null){
            user.setPassword_hash(newPassword);
        }
        return "Password Updated!";
    }



}
