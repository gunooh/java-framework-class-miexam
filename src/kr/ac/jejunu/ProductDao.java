package kr.ac.jejunu;

import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.*;
import java.util.Random;

public class ProductDao {
    private JdbcContext jdbcContext;

    public ProductDao()
    {

    }

    public Product get(Long id) throws ClassNotFoundException, SQLException {
        StatementStrategy statementStrategy = new GetProductStatementStrategy(id);
        return jdbcContext.jdbcContextWithStatementStrategyForQuery(statementStrategy);
    }



    public void add(Product product) throws SQLException, ClassNotFoundException {
        StatementStrategy statementStrategy = new AddProductStatementStrategy(product);
        jdbcContext.jdbcContextWithStatementStrategyForUpdate(statementStrategy);
    }


    public void delete(Long id) throws SQLException {
        StatementStrategy statementStrategy = new DeleteProductStatementStrategy(id);
        jdbcContext.jdbcContextWithStatementStrategyForUpdate(statementStrategy);
    }

    public void update(Product product) throws SQLException {
        StatementStrategy statementStrategy = new UpdateProductStatementStrategy(product);
        jdbcContext.jdbcContextWithStatementStrategyForUpdate(statementStrategy);
    }

    public void setJdbcContext(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }
}
