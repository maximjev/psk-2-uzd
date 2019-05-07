package lt.vu.usecases.cdi.simple;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Student;
import lt.vu.entities.University;
import lt.vu.usecases.cdi.dao.StudentDAO;
import lt.vu.usecases.cdi.dao.UniversityDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Model
public class StudentsForUniversityController {

    private static String CALLBACK_URL = "students-for-university?faces-redirect=true&universityId=";

    @Getter
    @Setter
    private University university;

    @Getter
    @Setter
    private Student student = new Student();

    @Inject
    private UniversityDAO universityDAO;

    @Inject
    private StudentDAO studentDAO;

    @PostConstruct
    public void init() {
        String universityId = FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get("universityId");
        if (universityId == null) {
            return;
        }
        this.university = universityDAO.findById(Integer.parseInt(universityId));
    }

    @Transactional
    public String createStudent() {
        student.setUniversity(university);
        university.getStudentList().add(student);
        studentDAO.create(student);
        return CALLBACK_URL + this.university.getId();
    }
}
