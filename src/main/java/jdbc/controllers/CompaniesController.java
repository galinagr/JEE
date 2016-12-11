package jdbc.controllers;

import jdbc.dao.CompaniesDAO;
import jdbc.modules.Companies;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.List;

public class CompaniesController {

    private PlatformTransactionManager txManager;
    private CompaniesDAO companiesDAO;

    public void setTxManager(PlatformTransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setCompaniesDAO(CompaniesDAO companiesDAO) {
        this.companiesDAO = companiesDAO;
    }

    public List<Companies> getAllCompanies() {
        TransactionStatus status = txManager.getTransaction(new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED));
        try {
            List<Companies> result = companiesDAO.createSetAllCompanies();
            txManager.commit(status);
            return result;
        } catch (Exception e) {
            txManager.rollback(status);
            throw new RuntimeException();
        }
    }

    @Transactional
    public Companies getCompaniesByName(String compName) {
        return companiesDAO.selectCompaniesByName(compName);
    }

}