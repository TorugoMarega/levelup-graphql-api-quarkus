package br.com.torugo.service;

import br.com.torugo.domain.College;
import br.com.torugo.domain.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;


@ApplicationScoped
public class PersonService {

//    @Transactional
//    public Person addPerson(Person person){
//        Person newPerson = person;
//        person.persist();
//        return newPerson;
//    }


    public List<Person> listAllPerson(){
        return Person.listAll();
    }

    @Transactional
    public Person updatePerson(Person person, Long id){
        Person updatePerson = Person.findById(id);
        if(person.getFirst_name() != null ){
            updatePerson.setFirst_name(person.getFirst_name());
        }
        if (person.getLast_name() != null) {
            updatePerson.setLast_name(person.getLast_name());
        }
        if (person.getCpf() != null) {
            updatePerson.setCpf(person.getCpf());
        }
        if (person.getAge() != null) {
            updatePerson.setAge(person.getAge());
        }
        updatePerson.persist();
        return updatePerson;
    }

    @Transactional
    public College updateCollege(College college, Long id){
        College updateCollege = College.findById(id);
        if(college.getCourse() != null ){
            updateCollege.setCourse(college.getCourse());
        }
        if(college.getUniversity() != null ){
            updateCollege.setUniversity(college.getUniversity());
        }
        if(college.getPeriod() != null ){
            updateCollege.setPeriod(college.getPeriod());
        }
        updateCollege.persist();
        return updateCollege;
    }
}
