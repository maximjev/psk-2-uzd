package lt.vu.usecases.cdi.dao;

import lt.vu.entities.Student;
import lt.vu.entities.University;
import lt.vu.usecases.cdi.interceptors.PersistInterceptor;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class StudentDAO {
    @Inject
    private EntityManager em;

    @PersistInterceptor
    public void create(Student student) {
        em.persist(student);
    }

    public void updateAndFlush(Student student) {
        em.merge(student);
        em.flush();
    }

    public List<Student> getAllStudents() {
        return em.createNamedQuery("Student.findAll", Student.class).getResultList();
    }

    public Student findById(Integer id) {
        return em.find(Student.class, id);
    }

    public List<Student> getStudentsOfUniversity(University university) {
        return em.createNamedQuery("Student.findByUniversity", Student.class)
                .setParameter("university", university)
                .getResultList();
    }
}
