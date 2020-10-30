package jdbc;

import java.util.List;

public interface goodsDAO<K extends Number, T> {
    List<T> findALL();

    T findEntityById(K id);

    void delete(K id);

    void delete(T entity);

    void update(T entity);
}
