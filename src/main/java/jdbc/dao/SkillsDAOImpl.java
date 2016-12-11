package jdbc.dao;

import jdbc.modules.Skills;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SkillsDAOImpl implements SkillsDAO {
    private DataSource dataSource;
    public static PreparedStatement preparedStatement = null;

    private static final Logger LOGGER = LoggerFactory.getLogger(SkillsDAOImpl.class);


    @Transactional(propagation = Propagation.MANDATORY)
    public void updateSkillsDescription(String skillDescr, int skillId) {

        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement =
                    connection.prepareStatement(SQL_Queries.SQL_UPDATE_SKILLS_DESCR_BY_ID);
            statement.setString(1, "NEW_SKILL");
            statement.setInt(2, 3003);
            statement.executeUpdate();
            createSetAllSkills();
        } catch (SQLException e) {
            LOGGER.error("Exception occurred during DB connection to " + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Skills> createSetAllSkills() {
        List<Skills> result = new ArrayList<>();
        LOGGER.info("Connection to DB");

        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_Queries.SQL_SELECT_ALL_SKILLS);
         while (resultSet.next()) {
                Skills skills = createSkill(resultSet);
                result.add(skills);
            }

            LOGGER.info("Successfully connected");
            System.out.println("The Skill with ID = \"3003\" has been changed to " + result);
        } catch (SQLException e) {
            LOGGER.error("Exception occurred during DB connection to " + e);
            throw new RuntimeException(e);
        }
        return result;
    }

    private Skills createSkill(ResultSet resultSet) throws SQLException {
        Skills skills = new Skills();
        skills.setSkillId(resultSet.getInt("SKILL_ID"));
        skills.setSkillDescr(resultSet.getString("SKILL_DESCR"));
        System.out.println(skills.toString());
        return skills;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

}