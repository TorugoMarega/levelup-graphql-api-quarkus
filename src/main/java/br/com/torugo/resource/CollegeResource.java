package br.com.torugo.resource;


import br.com.torugo.model.Course;
import br.com.torugo.model.University;
import br.com.torugo.service.CollegeService;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;

import javax.inject.Inject;
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
