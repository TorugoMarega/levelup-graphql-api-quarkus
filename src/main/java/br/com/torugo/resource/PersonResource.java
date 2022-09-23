package br.com.torugo.resource;

import br.com.torugo.domain.Person;
import br.com.torugo.service.PersonService;
import org.eclipse.microprofile.graphql.*;

import javax.inject.Inject;
import java.util.List;

@GraphQLApi
public class PersonResource {

    @Inject
    private PersonService service;

    @Query
    @Name("listAllPerson")
    public List<Person> listAllPerson(){
        return this.service.listAllPerson();
    }

    @Mutation
    public Person addPerson(Person person){
        return service.addPerson(person);
    }



//    @Name("address")
//    public Address findAddress(@Source Person person){
//        Address address = new Address();
//        address.setNumber(123);
//        address.setStreet("Rua sem nome");
//        return address;
//    }
//
//    @Mutation
//    public Person addPerson(Person person){
//        return person;
//    }
}