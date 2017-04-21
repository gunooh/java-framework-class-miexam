package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by PARK on 2017-04-21.
 */
public class JejuConnectionMaker implements ConnectionMaker {
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://117.17.102.106/portal", "root", "1234");
    }
}
