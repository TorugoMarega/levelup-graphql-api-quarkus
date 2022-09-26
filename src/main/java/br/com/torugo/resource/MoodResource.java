package br.com.torugo.resource;

import br.com.torugo.domain.User;
import br.com.torugo.domain.UserMood;
import br.com.torugo.service.MoodService;
import br.com.torugo.service.UserService;
import org.eclipse.microprofile.graphql.*;

import java.util.List;

@GraphQLApi
public class MoodResource {
    MoodService moodService;

    @Mutation
    @Description("Atualiza o mood do Usuário")
    public User updateUserMood(@Name("id") Long id, @Name("userStatus") UserMood userStatus){
        return this.moodService.updateUserMood(id, userStatus);
    }

    @Query
    @Name("listAllMood")
    @Description("Retorna a lista com todos os moods dos usuarios")
    public List<String> listAllMood(){
        return this.moodService.listAllMood();
    }
}
