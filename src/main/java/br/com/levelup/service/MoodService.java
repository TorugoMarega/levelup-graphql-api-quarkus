package br.com.levelup.service;

import br.com.levelup.model.User;
import br.com.levelup.model.UserMood;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


public class MoodService {

    @Transactional
    public User updateUserMood(Long id, UserMood userMood) {
        User updateUserMood = User.findById(id);
        updateUserMood.setUserMood(userMood.toString());
        updateUserMood.persist();
        return updateUserMood;
    }

    public List<String> listAllMood(){
        List<String> moodList = new ArrayList<>();
        moodList.add(UserMood.ESTRESSADO.toString());
        moodList.add(UserMood.PISTOLA.toString());
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
