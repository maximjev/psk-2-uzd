package lt.vu.usecases.cdi.dao;

import lt.vu.entities.Course;

import javax.enterprise.inject.Specializes;

@Specializes
public class CourseDAOSpecializes extends CourseDAO {
    @Override
    public void create(Course course) {
        System.out.println("I am Special!");
        super.create(course);
    }
}
