package kr.ac.jejunu;

import org.junit.Test;

import java.sql.SQLException;
import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProductDaoTest {
    @Test
    public void Jejuget() throws SQLException, ClassNotFoundException {
        Long id = 1L;
        String title = "제주감귤";
        Integer price = 15000;

        ProductDao productDao = new JejuProductDao();
        Product product = productDao.get(id);
        assertThat(id, is(product.getId()));
        assertThat(title, is(product.getTitle()));
        assertThat(price, is(product.getPrice()));
    }

    public void Jejuadd() throws SQLException, ClassNotFoundException {
        Long id = Long.valueOf(new Random().nextInt());
        String title = "제주감귤";
        Integer price = 15000;

        Product product = new Product();
        product.setId(id);
        product.setTitle(title);
        product.setPrice(price);

        ProductDao productDao = new JejuProductDao();

        productDao.add(product);

        Product addedProduct = productDao.get(id);

        assertThat(id, is(addedProduct.getId()));
        assertThat(title, is(addedProduct.getTitle()));
        assertThat(price, is(addedProduct.getPrice()));
    }

    @Test
    public void Hallaget() throws SQLException, ClassNotFoundException {
        Long id = 1L;
        String title = "제주감귤";
        Integer price = 15000;

        ProductDao productDao = new HallaProductDao();
        Product product = productDao.get(id);
        assertThat(id, is(product.getId()));
        assertThat(title, is(product.getTitle()));
        assertThat(price, is(product.getPrice()));
    }

    public void Hallaadd() throws SQLException, ClassNotFoundException {
        Long id = Long.valueOf(new Random().nextInt());
        String title = "제주감귤";
        Integer price = 15000;

        Product product = new Product();
        product.setId(id);
        product.setTitle(title);
        product.setPrice(price);

        ProductDao productDao = new HallaProductDao();

        productDao.add(product);

        Product addedProduct = productDao.get(id);

        assertThat(id, is(addedProduct.getId()));
        assertThat(title, is(addedProduct.getTitle()));
        assertThat(price, is(addedProduct.getPrice()));
    }
}
