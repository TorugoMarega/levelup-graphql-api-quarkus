package br.com.torugo.resource;

import br.com.torugo.model.User;
import br.com.torugo.model.UserMood;
import br.com.torugo.service.MoodService;
import org.eclipse.microprofile.graphql.*;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@GraphQLApi
public class MoodResource {

    private MoodService moodService = new MoodService();

    @Mutation
    @Transactional
    @Description("Atualiza o mood do Usuário")
    public User updateUserMood(@Name("id") Long id, @Name("userMood") UserMood userMood){
        return this.moodService.updateUserMood(id, userMood);
    }

    @Query
    @Name("listAllMood")
    @Description("Retorna a lista com todos os moods dos usuarios")
    public List<String> listAllMood(){
        return this.moodService.listAllMood();
    }
}
