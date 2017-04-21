package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by PARK on 2017-04-21.
 */
public interface StatementStrategy {
        public abstract PreparedStatement makeStatement(Object object, Connection connection) throws SQLException;
}
