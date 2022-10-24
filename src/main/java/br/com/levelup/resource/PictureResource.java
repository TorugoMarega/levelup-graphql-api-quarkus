package br.com.levelup.resource;

import br.com.levelup.model.User;
import br.com.levelup.service.PictureService;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;

import javax.transaction.Transactional;

@GraphQLApi
public class PictureResource {

    private PictureService service = new PictureService();

    @Mutation
    @Transactional
    @Description("Atualiza a foto de perfil")
    public User updateProfilePicture(Long id, String newPicture){
        return this.service.updateProfilePicture(id,newPicture);
    }

    @Mutation
    @Transactional
    @Description("Atualiza a foto do Avatar")
    public User updateAvatarPicture(Long id, String newPicture){
        return this.service.updateAvatarPicture(id,newPicture);
    }

////
////    @Mutation
////    @Description("Upload imagem")
////    @Consumes(MediaType.MULTIPART_FORM_DATA)
////    public String uploadProfilePicture (InputStream input){
////        input.
////        return "Upload com sucesso!";
////    }
}
