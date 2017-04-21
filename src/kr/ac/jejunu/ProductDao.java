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
        jdbcContext.jdbcContextWithStatementStrategyForUpdate(new StatementStrategy() {
            String query = "insert into product(id, title, price) values(?, ?, ?)";
            Object[] params = {product.getId(), product.getTitle(), product.getPrice()};
            @Override
            public PreparedStatement makeStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                for(int i=1; i<=params.length; i++)
                {
                    preparedStatement.setObject(i, params[i-1]);
                }
                return preparedStatement;
            }
        });
    }

    public void delete(final Long id) throws SQLException {
        jdbcContext.jdbcContextWithStatementStrategyForUpdate(new StatementStrategy() {
            String query = "delete from product where id = ?";
            Object[] params = {id};
            @Override
            public PreparedStatement makeStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                for(int i=1; i<=params.length; i++)
                {
                    preparedStatement.setObject(i, params[i-1]);
                }
                return preparedStatement;
            }
        });
    }

    public void update(final Product product) throws SQLException {
        jdbcContext.jdbcContextWithStatementStrategyForUpdate(new StatementStrategy() {
            String query = "update product set title = ?, price = ? where id =?";
            Object[] params = {product.getTitle(), product.getPrice(), product.getId()};
            @Override
            public PreparedStatement makeStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                for(int i=1; i<=params.length; i++)
                {
                    preparedStatement.setObject(i, params[i-1]);
                }
                return preparedStatement;
            }
        });
    }

    public void setJdbcContext(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }
}
