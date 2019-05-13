package lt.vu.rest;

import lt.vu.entities.Student;
import lt.vu.usecases.cdi.dao.StudentDAO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@ApplicationScoped
@Path("/student")
@Produces(MediaType.APPLICATION_JSON)
public class StudentRestServiceImpl implements StudentRestService {

    @Inject
    private EntityManager em;

    @Inject
    private StudentDAO studentDAO;

    @GET
    @Path("/{studentId}")
    public Student find(@PathParam("studentId") Integer studentId) {
        return em.find(Student.class, studentId);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public void create(StudentDTO studentDto) {
        Student student = new Student();
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setRegistrationNo(studentDto.getRegistrationNo());
        studentDAO.create(student);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{studentId}")
    @Transactional
    public void update(@PathParam("studentId") Integer studentId, StudentDTO studentDto) {
        Student student = em.find(Student.class, studentId);
        if (student == null) {
            student = new Student();
        }
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setRegistrationNo(studentDto.getRegistrationNo());
        studentDAO.updateAndFlush(student);
    }
}
