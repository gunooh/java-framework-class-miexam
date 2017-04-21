package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by PARK on 2017-04-21.
 */
public class GetProductStatementStrategy implements StatementStrategy {

        @Override
        public PreparedStatement makeStatement(Object object, Connection connection) throws SQLException, SQLException {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from product where id = ?");
            preparedStatement.setLong(1, (Long) object);
            return preparedStatement;
        }


}
