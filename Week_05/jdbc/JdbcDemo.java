package week05.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author xiaoshuai.guo
 * @Date 2020-11-18 18:58
 */
public class JdbcDemo {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/demo";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        Connection connection = null;
//        Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
//            statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery("select * from stu");
            String sql = "select * from stu where age=? and name=?";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, 44);
            preparedStatement.setString(2, "hhh");
            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int age = rs.getInt("age");
                String name = rs.getString("name");
                System.out.println("age:" + age + ", name" + name);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (null != preparedStatement) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
