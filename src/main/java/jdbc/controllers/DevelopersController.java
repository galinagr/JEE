package jdbc.controllers;


import jdbc.dao.DevelopersDAO;
import jdbc.modules.Developers;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.List;

public class DevelopersController {

    private PlatformTransactionManager txManager;
    private DevelopersDAO developersDAO;

    public void setTxManager(PlatformTransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setDevelopersDAO(DevelopersDAO developersDAO) {
        this.developersDAO = developersDAO;
    }

    public List<Developers> getAllDevelopers() {
        TransactionStatus status = txManager.getTransaction(new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED));
        try {
            List<Developers> result = developersDAO.createSetAllDevelopers();
            txManager.commit(status);
            return result;
        } catch (Exception e) {
            txManager.rollback(status);
            throw new RuntimeException();
        }
    }

    @Transactional
    public Developers getDevelopersById(int devId) {
        return developersDAO.selectDevelopersByID(devId);
    }

}
