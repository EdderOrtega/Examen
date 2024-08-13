package dao;

import java.sql.SQLException;
import java.util.List;

public interface IDao<T> {
    T guardar(T t) throws SQLException;
    List<T> buscarTodos();
}
