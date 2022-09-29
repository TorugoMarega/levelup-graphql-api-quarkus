package br.com.torugo.service;

import br.com.torugo.model.User;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
@ApplicationScoped
public class PictureService {
    //--------------------------------- ATUALIZA FOTOS DE PERFIL E AVATAR --------------------------------
    @Transactional
    public String updateProfilePicture(Long id, String newPicture){
        User user = User.findById(id);
        user.setProfile_picture(newPicture);
        user.persist();
        return newPicture;
    }

    @Transactional
    public String updateAvatarPicture(Long id, String newPicture){
        User user = User.findById(id);
        user.setProfile_avatar(newPicture);
        user.persist();
        return newPicture;
    }
}
