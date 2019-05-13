package lt.vu.rest;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public abstract class StudentRestServiceDecorator implements StudentRestService {

    @Inject
    @Delegate
    @Any
    private StudentRestService service;

    public void create(StudentDTO studentDTO) {
        System.out.println(String.format("Student %s %s created through REST service",
                studentDTO.getFirstName(), studentDTO.getLastName()));
        service.create(studentDTO);
    }
}
