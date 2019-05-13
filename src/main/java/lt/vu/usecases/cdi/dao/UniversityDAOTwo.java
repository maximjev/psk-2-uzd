package lt.vu.usecases.cdi.dao;

import lt.vu.entities.University;
import lt.vu.usecases.cdi.interceptors.PersistInterceptor;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@Alternative
@ApplicationScoped
public class UniversityDAOTwo implements UniversityDAO {
    @Inject
    private EntityManager em;

    @PersistInterceptor
    public void create(University university) {
        System.out.println("I am Two");
        em.persist(university);
    }

    public List<University> getAllUniversities() {
        System.out.println("I am Two");
        return em.createNamedQuery("University.findAll", University.class).getResultList();
    }

    public University findById(Integer id) {
        System.out.println("I am Two");
        return em.find(University.class, id);
    }
}
