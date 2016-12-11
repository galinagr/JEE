package jdbc.dao;

import jdbc.modules.Projects;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProjectsDAO {
    @Transactional(propagation = Propagation.MANDATORY)
    void updateProject(String projectName, String projectDesc, int quantityDev, int profit, int costs, int projId);

    @Transactional(propagation = Propagation.MANDATORY)
    List<Projects> createSetAllProjects();
}
