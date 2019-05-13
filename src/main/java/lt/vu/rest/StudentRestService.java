package lt.vu.rest;

import lt.vu.entities.Student;

import javax.ws.rs.PathParam;


public interface StudentRestService {

    Student find(Integer studentId);

    void create(StudentDTO studentDTO);

    void update(Integer studentId, StudentDTO studentDTO);
}
