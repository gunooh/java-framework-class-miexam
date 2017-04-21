package kr.ac.jejunu;

import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.*;
import java.util.Random;

public class ProductDao {
    private JdbcContext jdbcContext;

    public ProductDao() {
    }

    public Product get(final Long id) throws ClassNotFoundException, SQLException {
        return jdbcContext.jdbcContextWithStatementStrategyForQuery(new StatementStrategy() {
            String query = "select * from product where id = ?";
            Object[] params = {id};
            @Override
            public PreparedStatement makeStatement(Connection connection) throws SQLException, SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                for(int i=1; i<=params.length; i++)
                {
                    preparedStatement.setObject(i, params[i-1]);
                }
                return preparedStatement;
            }
        });
    }

    public void add(final Product product) throws SQLException, ClassNotFoundException {
        final String query = "insert into product(id, title, price) values(?, ?, ?)";
        final Object[] params = {product.getId(), product.getTitle(), product.getPrice()};

        jdbcContext.update(query, params);
    }

    public void delete(final Long id) throws SQLException {
        final String query = "delete from product where id = ?";
        final Object[] params = {id};

        jdbcContext.update(query, params);
    }

    public void update(final Product product) throws SQLException {
        final String query = "update product set title = ?, price = ? where id =?";
        final Object[] params = {product.getTitle(), product.getPrice(), product.getId()};

        jdbcContext.update(query, params);
    }

    public void setJdbcContext(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }
}
