package kr.ac.jejunu;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.sql.SQLException;
import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProductDaoTest {

    private ProductDao productDao;

    @Before
    public void setup()
    {
        ApplicationContext context = new GenericXmlApplicationContext("daoFactory.xml");
        productDao = context.getBean("productDao", ProductDao.class);
    }

    @Test
    public void get() throws SQLException, ClassNotFoundException {
        Long id = 1L;
        String title = "제주감귤";
        Integer price = 15000;

        Product product = productDao.get(id);
        assertThat(id, is(product.getId()));
        assertThat(title, is(product.getTitle()));
        assertThat(price, is(product.getPrice()));
    }

    public void add() throws SQLException, ClassNotFoundException {
        Long id = Long.valueOf(new Random().nextInt());
        String title = "제주감귤";
        Integer price = 15000;

        Product product = new Product();
        product.setId(id);
        product.setTitle(title);
        product.setPrice(price);

        productDao.add(product);

        Product addedProduct = productDao.get(id);

        assertThat(id, is(addedProduct.getId()));
        assertThat(title, is(addedProduct.getTitle()));
        assertThat(price, is(addedProduct.getPrice()));
    }

}
