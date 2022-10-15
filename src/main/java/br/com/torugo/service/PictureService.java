package br.com.torugo.service;

import br.com.torugo.model.User;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class PictureService {
    @Transactional
    public User updateProfilePicture(Long id, String newPicture){
        User user = User.findById(id);
        user.setProfile_picture(newPicture);
        user.persist();
        return user;
    }
    @Transactional
    public String updateAvatarPicture(Long id, String newPicture){
        User user = User.findById(id);
        user.setProfile_avatar(newPicture);
        return newPicture;
    }
}
