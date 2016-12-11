package jdbc.dao;


import jdbc.modules.Developers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DevelopersDAOImpl implements DevelopersDAO {

    private DataSource dataSource;

    private static final Logger LOGGER = LoggerFactory.getLogger(DevelopersDAOImpl.class);

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Developers selectDevelopersByID(int devId) {

        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement =
                    connection.prepareStatement(SQL_Queries.SQL_SELECT_ALL_FROM_DEVELOPERS_BY_ID);
            statement.setInt(1, 1001);
            ResultSet resultSet = statement.executeQuery();
            System.out.println("The Developer with ID = 1001  " + resultSet);
            if (resultSet.next()) {
                return createDeveloper(resultSet);
            } else {
                throw new RuntimeException("Cannot find DEV with devId " + devId);
            }


        } catch (SQLException e) {
            LOGGER.error("Exception occurred during DB connection to " + e);
            throw new RuntimeException(e);
        }

    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Developers> createSetAllDevelopers() {
        List<Developers> result = new ArrayList<>();
        LOGGER.info("Connection to DB");

        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_Queries.SQL_SELECT_ALL_DEVELOPERS);
            while (resultSet.next()) {
                Developers developers = createDeveloper(resultSet);
                result.add(developers);
            }

            LOGGER.info("Successfully connected");
        } catch (SQLException e) {
            LOGGER.error("Exception occurred during DB connection to " + e);
            throw new RuntimeException(e);
        }
        return result;
    }

    private Developers createDeveloper(ResultSet resultSet) throws SQLException {
        Developers developers = new Developers();
        developers.setDevId(resultSet.getInt("DEV_ID"));
        developers.setDateOfEmp(resultSet.getString("DATE_OF_EMP"));
        developers.setForname(resultSet.getString("FORNAME"));
        developers.setSurname(resultSet.getString("SURNAME"));
        developers.setSalary(resultSet.getInt("SALARY"));
        developers.setPosInProject(resultSet.getString("POS_IN_PROJECT"));
        System.out.println(developers.toString());
        return developers;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

}
