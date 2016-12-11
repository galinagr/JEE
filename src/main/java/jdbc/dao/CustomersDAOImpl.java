package jdbc.dao;

import jdbc.modules.Customers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomersDAOImpl implements CustomersDAO {

    private DataSource dataSource;

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomersDAOImpl.class);

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void updateCustomersExpenses(int mult, int custId) {

        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement =
                    connection.prepareStatement(SQL_Queries.SQL_UPDATE_CUSTOMERS_EXPENSES);
            statement.setInt(1, 3);
            statement.setInt(2, 5003);
            statement.executeUpdate();
            createSetAllCustomers();
        } catch (SQLException e) {
            LOGGER.error("Exception occurred during DB connection to " + e);
            throw new RuntimeException(e);
        }

    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Customers> createSetAllCustomers() {
        List<Customers> result = new ArrayList<>();
        LOGGER.info("Connection to DB");

        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_Queries.SQL_SELECT_ALL_CUSTOMERS);
            while (resultSet.next()) {
                Customers customers = createCustomer(resultSet);
                result.add(customers);
            }
            LOGGER.info("Successfully connected");
            System.out.println("The Customer with new ID = \"2003\"" + result);
        } catch (SQLException e) {
            LOGGER.error("Exception occurred during DB connection to " + e);
            throw new RuntimeException(e);
        }
        return result;
    }

    private Customers createCustomer(ResultSet resultSet) throws SQLException {
        Customers customers = new Customers();
        customers.setCustId(resultSet.getInt("CUST_ID"));
        customers.setCustName(resultSet.getString("CUST_NAME"));
        customers.setCustExpenses(resultSet.getInt("CUST_EXPENSES"));
        System.out.println(customers.toString());
        return customers;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

}


