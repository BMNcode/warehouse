package jdbc;

import model.Goods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.CheckedOutputStream;

public class goodsDAOImpl implements goodsDAO<Integer, Goods> {

    private static final Logger logger = LoggerFactory.getLogger(goodsDAOImpl.class);

    public static final String SQL_SELECT_ALL_GOODS = "SELECT * FROM GOODS";
    public static final String SQL_SELECT_GOODS_ID = "SELECT * FROM GOODS WHERE id_product = ?";
    public static final String SQL_DELETE_GOODS_ENTITY = "DELETE FROM GOODS WHERE name_product = ?";
    public static final String SQL_DELETE_GOODS_ID = "DELETE FROM GOODS WHERE id_product = ?";
    public static final String SQL_UPDATE_GOODS_ENTITY = "UPDATE GOODS SET name_product = ?, unit_product = ?, description = ? WHERE name_product = ?";

    @Override
    public List<Goods> findALL() {
        List<Goods> goods = new ArrayList<>();
        try (Connection connection = ConnectionUtils.getMyConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(SQL_SELECT_ALL_GOODS);
            while (rs.next()) {
                int id = rs.getInt("id_product");
                String nameProduct = rs.getString("name_product");
                String unitProduct = rs.getString("unit_product");
                String description = rs.getString("description");
                goods.add(new Goods(id, nameProduct, unitProduct, description));
            }

        } catch (SQLException e) {
            logger.error("ERROR", e);
        }
        return goods;
    }

    @Override
    public Goods findEntityById(Integer id) {
        Goods goods = null;
        try (Connection connection = ConnectionUtils.getMyConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_GOODS_ID)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String nameProduct = rs.getString("name_product");
                String unitProduct = rs.getString("unit_product");
                String description = rs.getString("description");
                goods = new Goods(id, nameProduct, unitProduct, description);
            }
        } catch (SQLException e) {
            logger.error("ERROR", e);
        }
        return goods;
    }

    @Override
    public void delete(Integer id) {
        try (Connection connection = ConnectionUtils.getMyConnection()) {
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE_GOODS_ID);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("ERROR", e);
        }

    }

    @Override
    public void delete(Goods entity) {
        try (Connection connection = ConnectionUtils.getMyConnection()) {
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE_GOODS_ENTITY);
            statement.setString(1, entity.getNameProduct());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("ERROR", e);
        }

    }

    @Override
    public void update(Goods entity) {
        try (Connection connection = ConnectionUtils.getMyConnection()) {
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_GOODS_ENTITY);
            statement.setString(1, entity.getNameProduct());
            statement.setString(2, entity.getUnitProduct());
            statement.setString(3, entity.getDescription());
            statement.setString(4, entity.getNameProduct());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("ERROR", e);
        }
    }
}
