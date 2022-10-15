package br.com.torugo.resource;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

@GraphQLApi
public class TestConnection {
    @Query
    public String testConnection(){
        return "Conxexão estabelecida!";
    }
}
