package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by PARK on 2017-04-21.
 */
public class AddProductStatementStrategy implements StatementStrategy {
    private Product product;

    public AddProductStatementStrategy(Product product)
    {
        this.product = product;
    }

    @Override
    public PreparedStatement makeStatement(Connection connection) throws SQLException, SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into product(id, title, price) values(?, ?, ?)");
        preparedStatement.setLong(1, product.getId());
        preparedStatement.setString(2, product.getTitle());
        preparedStatement.setInt(3, product.getPrice());

        return preparedStatement;
    }
}
