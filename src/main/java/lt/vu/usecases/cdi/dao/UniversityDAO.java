package lt.vu.usecases.cdi.dao;

import lt.vu.entities.University;
import lt.vu.usecases.cdi.interceptors.PersistInterceptor;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;


public interface UniversityDAO {

    void create(University university);


    List<University> getAllUniversities();

    University findById(Integer id);
}
