package week05.jdbc;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author xiaoshuai.guo
 * @Date 2020-11-18 19:12
 */
public class JdbcHikariDemo {

    public static void main(String[] args) {
        String configFile = JdbcHikariDemo.class.getClassLoader().getResource("application.properties").getPath();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        HikariDataSource ds = new HikariDataSource(new HikariConfig(configFile));

        try {
            connection = ds.getConnection();
            String sql = "select * from stu where age=? and name=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 44);
            preparedStatement.setString(2, "hhh");

            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                System.out.format("%d %s %n", rs.getInt(1), rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
                ds.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }
}
