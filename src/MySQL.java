import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQL {
    private String DB_URL;
    private String user;
    private String password;

    //建立联系
    public Connection getConnection(String DB_URL, String user, String password) throws ClassNotFoundException {
        Connection connection = null;

        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Linking the MysqlDB");
        try {
            connection = (Connection) DriverManager.getConnection(DB_URL, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    //最后关闭清理打开端口
    public static void close(PreparedStatement preparedStatement, com.mysql.jdbc.Connection connection, ResultSet resultSet) throws SQLException {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
