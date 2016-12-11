package jdbc.dao;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.*;

public class BaseDAO {

    public static Connection connection = null;
    public static Statement statement = null;
    public static PreparedStatement preparedStatement = null;
    private static DataSource dataSource;

    public void ConnectDB() throws SQLException, ClassNotFoundException {
        Class.forName("oracle.jdbc.OracleDriver()");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "galina", "galina");
    }
    @Transactional(propagation = Propagation.MANDATORY)
    public static int changeRecord(int id, String sql, String name) throws SQLException {
        Connection connection = dataSource.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, id);
        int resultSet = preparedStatement.executeUpdate();
        preparedStatement.close();
        return resultSet;
    }

       public ResultSet selectRecord(String sql) throws SQLException {
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        return resultSet;
    }

    public void changeRecord(String sql, int...id) throws SQLException {
        preparedStatement = connection.prepareStatement(sql);
        int i = 1;
        for (int x : id){
            preparedStatement.setInt(i, x);
            ++i;
        }
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void addRecord(String sql, String name, int...id) throws SQLException {
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id[0]);
        preparedStatement.setString(2, name);
        if (id.length == 2){
            preparedStatement.setInt(3, id[1]);
        }
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void closeConnect() throws SQLException {
        connection.close();
    }
}
