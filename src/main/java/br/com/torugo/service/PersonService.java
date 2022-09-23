package br.com.torugo.service;

import br.com.torugo.domain.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;


@ApplicationScoped
public class PersonService {

    @Transactional
    public Person addPerson(Person person){
        Person newPerson = person;
        person.persist();
        return newPerson;
    }


    public List<Person> listAllPerson(){
        return Person.listAll();
    }


}
