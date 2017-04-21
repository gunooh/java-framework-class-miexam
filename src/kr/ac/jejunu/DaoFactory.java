package kr.ac.jejunu;

/**
 * Created by PARK on 2017-04-21.
 */
public class DaoFactory {

    public ProductDao getProductDao()
    {
        return new ProductDao(getConnectionMaker());
    }

    private JejuConnectionMaker getConnectionMaker()
    {
        return new JejuConnectionMaker();
    }
}
