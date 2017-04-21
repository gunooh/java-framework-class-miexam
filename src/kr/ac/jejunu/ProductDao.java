package kr.ac.jejunu;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.*;

public class ProductDao {
    private JdbcTemplate jdbcTemplate;

    public ProductDao() {
    }

    public Product get(final Long id) throws ClassNotFoundException, SQLException {
        String sql = "select * from product where id = ?";
        Object[] params = new Long[] {id};
        Product queryForObject = null;
        try {
            queryForObject = jdbcTemplate.queryForObject(sql, params, (resultSet, i) -> {

                    Product product = new Product();
                    product.setId(resultSet.getLong("id"));
                    product.setTitle(resultSet.getString("title"));
                    product.setPrice(resultSet.getInt("price"));
                    return product;
            });
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return queryForObject;
    }

    public void add(final Product product) throws SQLException, ClassNotFoundException {
        final String query = "insert into product(id, title, price) values(?, ?, ?)";
        final Object[] params = {product.getId(), product.getTitle(), product.getPrice()};

        jdbcTemplate.update(query, params);
    }

    public void delete(final Long id) throws SQLException {
        final String query = "delete from product where id = ?";
        final Object[] params = {id};

        jdbcTemplate.update(query, params);
    }

    public void update(final Product product) throws SQLException {
        final String query = "update product set title = ?, price = ? where id =?";
        final Object[] params = {product.getTitle(), product.getPrice(), product.getId()};

        jdbcTemplate.update(query, params);
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
