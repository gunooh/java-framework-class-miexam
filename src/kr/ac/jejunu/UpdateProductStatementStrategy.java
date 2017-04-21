package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by PARK on 2017-04-21.
 */
public class UpdateProductStatementStrategy implements StatementStrategy {

    @Override
    public PreparedStatement makeStatement(Object object, Connection connection) throws SQLException, SQLException {

        Product product = (Product) object;
        PreparedStatement preparedStatement = connection.prepareStatement("update product set title = ?, price = ? where id =?");
        preparedStatement.setString(1, product.getTitle());
        preparedStatement.setInt(2, product.getPrice());
        preparedStatement.setLong(3, product.getId());
        return preparedStatement;
    }

}
