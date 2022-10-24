package br.com.levelup.resource;


import br.com.levelup.model.Course;
import br.com.levelup.model.University;
import br.com.levelup.service.CollegeService;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;

import javax.transaction.Transactional;
import java.util.List;

@GraphQLApi
public class CollegeResource {

    CollegeService service = new CollegeService();

    @Mutation
    @Transactional
    public Course createCourse(Course course){
        return service.createCourse(course) ;
    }

    @Query
    public List<Course> listAllCourses(){
        return service.listAllCourses();
    }

    @Mutation
    @Transactional
    public University createUniversity(University university){
        return this.service.createUniversity(university);
    }

    @Query
    public List<University> listAllUniversities(){
        return service.listAllUniversities();
    }


}
