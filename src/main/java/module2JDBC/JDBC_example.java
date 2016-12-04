package module2JDBC;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class JDBC_example {
    private static final Logger LOGGER = LoggerFactory.getLogger(JDBC_example.class);

    public static void main(String[] args) {
        loadDriver();
        LOGGER.info("Connection to DB");
        String url = "jdbc:oracle:thin:@localhost:1521/xe";
        String user = "galina";
        String password = "galina";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM DEVELOPERS";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Developers developers = new Developers();
                developers.setDEV_ID(resultSet.getInt("DEV_ID"));
                developers.setDATE_OF_EMP(resultSet.getString("DATE_OF_EMP"));
                developers.setFORNAME(resultSet.getString("FORNAME"));
                developers.setSURNAME(resultSet.getString("SURNAME"));
                developers.setSALARY(resultSet.getInt("SALARY"));
                System.out.println(developers.toString());
            }

            LOGGER.info("Successfully connected");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void loadDriver() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            LOGGER.info("Driver successfully found");
        } catch (ClassNotFoundException e) {
            LOGGER.error("Cann't find driver:oracle.jdbc.driver.oracledriver");
            throw new RuntimeException(e);
        }
    }


}
