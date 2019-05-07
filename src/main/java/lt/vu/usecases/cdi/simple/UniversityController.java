package lt.vu.usecases.cdi.simple;

import lombok.Getter;
import lombok.Setter;
import lt.vu.usecases.mybatis.dao.UniversityMapper;
import lt.vu.usecases.mybatis.model.University;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class UniversityController {

    @Getter
    @Setter
    private University university = new University();

    @Getter
    private List<University> universities;

    @Inject
    private UniversityMapper universityMapper;

    @PostConstruct
    public void init() {
        universities = universityMapper.selectAll();
    }

    @Transactional
    public void createUniversity() {
        universityMapper.insert(university);
    }
}
