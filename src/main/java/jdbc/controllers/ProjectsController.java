package jdbc.controllers;

import jdbc.dao.ProjectsDAO;
import jdbc.modules.Projects;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.List;

public class ProjectsController {
    private PlatformTransactionManager txManager;
    private ProjectsDAO projectsDAO;

    public void setTxManager(PlatformTransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setProjectsDAO(ProjectsDAO projectsDAO) {
        this.projectsDAO = projectsDAO;
    }

    public List<Projects> getAllProjects() {
        TransactionStatus status = txManager.getTransaction(new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED));
        try {
            List<Projects> result = projectsDAO.createSetAllProjects();
            txManager.commit(status);
            return result;
        } catch (Exception e) {
            txManager.rollback(status);
            throw new RuntimeException();
        }
    }

    @Transactional
    public int updateProject (String projectName, String projectDesc, int quantityDev, int profit, int costs, int projId) {
        projectsDAO.updateProject(projectName, projectDesc, quantityDev, profit, costs,projId);
        return 1;
    }
}
