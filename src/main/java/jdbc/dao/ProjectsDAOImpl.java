package jdbc.dao;

import jdbc.modules.Projects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectsDAOImpl implements ProjectsDAO {
    private DataSource dataSource;

    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectsDAOImpl.class);

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void updateProject(String projectName, String projectDesc, int quantityDev, int profit, int costs, int projId) {

        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement =
                    connection.prepareStatement(SQL_Queries.SQL_UPDATE_PROJECTS);
            statement.setString(1, "BANK6");
            statement.setString(2, "FINE");
            statement.setInt(3, 80);
            statement.setInt(4, 10000);
            statement.setInt(5, 80000);
            statement.setInt(6, 2006);
            statement.executeUpdate();
            createSetAllProjects();
        } catch (SQLException e) {
            LOGGER.error("Exception occurred during DB connection to " + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Projects> createSetAllProjects() {
        List<Projects> result = new ArrayList<>();
        LOGGER.info("Connection to DB");

        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_Queries.SQL_SELECT_ALL_PROJECTS);
            while (resultSet.next()) {
                Projects projects = createProject(resultSet);
                result.add(projects);
            }

            LOGGER.info("Successfully connected");
            System.out.println("The New Projects updated is " + result);
        } catch (SQLException e) {
            LOGGER.error("Exception occurred during DB connection to " + e);
            throw new RuntimeException(e);
        }
        return result;
    }

    private Projects createProject(ResultSet resultSet) throws SQLException {
        Projects projects = new Projects();
        projects.setProjId(resultSet.getInt("PROJ_ID"));
        projects.setCosts(resultSet.getInt("COSTS"));
        projects.setProfit(resultSet.getInt("PROFIT"));
        projects.setProjectName(resultSet.getString("PROJECT_NAME"));
        projects.setProjectDesc(resultSet.getString("PROJECT_DESC"));
        projects.setQuantityDev(resultSet.getInt("QUANTITY_DEV"));
        System.out.println(projects.toString());
        return projects;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

}
