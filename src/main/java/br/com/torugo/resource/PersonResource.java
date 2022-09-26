package br.com.torugo.resource;

import br.com.torugo.domain.College;
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
    @Description("Retorna lista com todas as pessoas cadastradas")
    public List<Person> listAllPerson(){
        return this.service.listAllPerson();
    }

    @Mutation
    @Name("updateUserPerson")
    @Description("Atualiza os campos de pessoa")
    public Person updateUserPerson(Person person, @Name("id") Long id){
        return this.service.updatePerson(person, id);
    }

    @Mutation
    @Name("updateUserPersonCollege")
    @Description("Atualiza os dados academicos de uma pessoa")
    public College updateUserPersonCollege(College college, @Name("id") Long id){
        return this.service.updateCollege(college, id);
    }



//    @Mutation
//    public Person addPerson(Person person){
//        return service.addPerson(person);
//    }



//    @Name("address")
//    public Address findAddress(@Source Person person){
//        Address address = new Address();
//        address.setNumber(123);
//        address.setStreet("Rua sem nome");
//        return address;
//    }
}