package br.com.torugo.resource;

import br.com.torugo.service.PictureService;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;

import javax.inject.Inject;

@GraphQLApi
public class PictureResource {
    @Inject
    private PictureService service;

    @Mutation
    @Description("Atualiza a foto de perfil")
    public String updateProfilePicture(Long id, String newPicture){
        return this.service.updateProfilePicture(id,newPicture);
    }

    @Mutation
    @Description("Atualiza a foto do Avatar")
    public String updateAvatarPicture(Long id, String newPicture){
        return this.service.updateAvatarPicture(id,newPicture);
    }


}
