package kr.ac.jejunu;

import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.*;
import java.util.Random;

public class ProductDao {

    private DataSource dataSource;

    public ProductDao()
    {

    }

    public Product get(Long id) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Product product = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement("select * from product where id = ?");
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                product = new Product();
                product.setId(resultSet.getLong("id"));
                product.setTitle(resultSet.getString("title"));
                product.setPrice(resultSet.getInt("price"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if(resultSet!=null)
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if(preparedStatement!=null)
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if(connection!=null)
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }

        return product;
    }

    public void add(Product product) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = dataSource.getConnection();

            preparedStatement = connection.prepareStatement("insert into product(id, title, price) values(?, ?, ?)");
            preparedStatement.setLong(1, product.getId());
            preparedStatement.setString(2, product.getTitle());
            preparedStatement.setInt(3, product.getPrice());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if(preparedStatement!=null)
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if(connection!=null)
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }

    public void delete(Long id) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = dataSource.getConnection();

            preparedStatement = connection.prepareStatement("delete from user where id = ?");
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        finally {

            if(preparedStatement != null)
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if(connection != null)
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }

    public void update(Long id) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = dataSource.getConnection();

            preparedStatement = connection.prepareStatement("update product set id=? where id =?");
            preparedStatement.setLong(1, id);
            preparedStatement.setLong(2, new Random().nextInt());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        finally {

            if(preparedStatement != null)
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if(connection != null)
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }


    public void setDataSource(SimpleDriverDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public DataSource getDataSource() {
        return dataSource;
    }


}
