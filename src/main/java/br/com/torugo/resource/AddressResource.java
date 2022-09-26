package br.com.torugo.resource;

import br.com.torugo.domain.Address;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;

import java.util.Collections;
import java.util.List;

@GraphQLApi
public class AddressResource {

    @Query
    @Name("findAllAddress")
    public List<Address> findAllAddress(){
        Address address = new Address();
        address.setNumber(123);
        address.setStreet("Rua sem nome");
        return Collections.singletonList(address);
    }

}