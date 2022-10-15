package br.com.torugo.resource;

import br.com.torugo.model.User;
import br.com.torugo.service.PictureService;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;

@GraphQLApi
public class PictureResource {

    private PictureService service = new PictureService();

    @Mutation
    @Description("Atualiza a foto de perfil")
    public User updateProfilePicture(Long id, String newPicture){
        return this.service.updateProfilePicture(id,newPicture);
    }

    @Mutation
    @Description("Atualiza a foto do Avatar")
    public String updateAvatarPicture(Long id, String newPicture){
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
