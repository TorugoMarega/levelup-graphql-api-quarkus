package br.com.levelup.resource;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

import javax.annotation.security.RolesAllowed;

@GraphQLApi
public class TestConnection {
    @Query
    @RolesAllowed({"Aprendiz"})
    public String testConnection(){
        return "Conxexão estabelecida!";
    }
}
