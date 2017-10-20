package kr.or.dgit.jdbc_coffee.dao;

import java.sql.SQLException;
import java.util.List;

public abstract class AbstractDao<T> {
	public abstract void insertItem(T item) throws SQLException;
	public abstract void updateItem(T item) throws SQLException;
	public abstract T selectItemByCode(T item) throws SQLException;
	public abstract List<T> selectItemAll() throws SQLException;
}
