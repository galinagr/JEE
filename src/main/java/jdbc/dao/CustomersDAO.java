package jdbc.dao;

import jdbc.modules.Customers;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CustomersDAO {
    @Transactional(propagation = Propagation.MANDATORY)
    void updateCustomersExpenses(int mult, int custId);

    @Transactional(propagation = Propagation.MANDATORY)
    List<Customers> createSetAllCustomers();
}
