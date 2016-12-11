package jdbc.dao;

import jdbc.modules.Companies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompaniesDAOImpl implements CompaniesDAO {
    private DataSource dataSource;

    private static final Logger LOGGER = LoggerFactory.getLogger(CompaniesDAOImpl.class);

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Companies selectCompaniesByName(String compName) {

        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement =
                    connection.prepareStatement(SQL_Queries.SQL_SELECT_ALL_FROM_COMPANIES_BY_NAME);
            statement.setString(1, "SOFT_PLUS");
            ResultSet resultSet = statement.executeQuery();
            System.out.println("The Company with NAME = \"SOFT_PLUS\"" + resultSet);
            if (resultSet.next()) {
                return createCompany(resultSet);
            } else {
                throw new RuntimeException("Cannot find COMPANY with compName " + compName);
            }


        } catch (SQLException e) {
            LOGGER.error("Exception occurred during DB connection to " + e);
            throw new RuntimeException(e);
        }

    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Companies> createSetAllCompanies() {
        List<Companies> result = new ArrayList<>();
        LOGGER.info("Connection to DB");

        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_Queries.SQL_SELECT_ALL_COMPANIES);
            while (resultSet.next()) {
                Companies companies = createCompany(resultSet);
                result.add(companies);
            }

            LOGGER.info("Successfully connected");
        } catch (SQLException e) {
            LOGGER.error("Exception occurred during DB connection to " + e);
            throw new RuntimeException(e);
        }
        return result;
    }

    private Companies createCompany(ResultSet resultSet) throws SQLException {
        Companies companies = new Companies();
        companies.setcompId(resultSet.getInt("COMP_ID"));
        companies.setcompName(resultSet.getString("COMP_NAME"));
        companies.setcompAddr(resultSet.getString("COMP_ADDR"));
        System.out.println(companies.toString());
        return companies;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

}

