package jdbc;

import model.Goods;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestConnection {

    private static Connection connection;

    @Before
    public void init() throws SQLException {
        connection = ConnectionUtils.getMyConnection();
    }



    @Test
    public void testShouldGetJdbcConnection() throws SQLException {
        try(Connection connection = ConnectionUtils.getMyConnection()) {
            Assert.assertTrue(connection.isValid(1));
            Assert.assertFalse(connection.isClosed());
        }
    }

    @Test
    public void testShouldFindAllGoods() {
        goodsDAOImpl goodsDAO = new goodsDAOImpl();
        List<Goods> testList = goodsDAO.findALL();
        testList.forEach(x -> System.out.println(x.toString()));
    }

    @Test
    public void testShouldFindGoodsId() {
        goodsDAOImpl goodsDAO = new goodsDAOImpl();
        System.out.println(goodsDAO.findEntityById(1).toString());
    }

    @Test
    public void testShouldDeleteId() {
        goodsDAOImpl goodsDAO = new goodsDAOImpl();
        goodsDAO.delete(3);
    }

    @Test
    public void testShouldDeleteEntity() {
        goodsDAOImpl goodsDAO = new goodsDAOImpl();
        Goods goods = new Goods("Штукатурка ROTBAND", "шт", "поставляются в мешках по 30 кг");
        goodsDAO.delete(goods);
    }

    @Test
    public void testShouldUpdateEntity() {
        goodsDAOImpl goodsDAO = new goodsDAOImpl();
        Goods goods = new Goods("Штукатурка ROTBAND", "шт", "adfasdfasd");
        goodsDAO.update(goods);
    }

    @After
    public void close() throws SQLException {
        connection.close();
    }

}
