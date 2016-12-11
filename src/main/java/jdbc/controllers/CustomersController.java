package jdbc.controllers;

import jdbc.dao.CustomersDAO;
import jdbc.modules.Customers;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.List;

public class CustomersController {

    private PlatformTransactionManager txManager;
    private CustomersDAO customersDAO;

    public void setTxManager(PlatformTransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setCustomersDAO(CustomersDAO customersDAO) {
        this.customersDAO = customersDAO;
    }

    public List<Customers> getAllCustomers() {
        TransactionStatus status = txManager.getTransaction(new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED));
        try {
            List<Customers> result = customersDAO.createSetAllCustomers();
            txManager.commit(status);
            return result;
        } catch (Exception e) {
            txManager.rollback(status);
            throw new RuntimeException();
        }
    }

    @Transactional
    public int changeCustomersExpenses(int mult, int custId) {
        customersDAO.updateCustomersExpenses(mult, custId);
        return 1;
    }
}