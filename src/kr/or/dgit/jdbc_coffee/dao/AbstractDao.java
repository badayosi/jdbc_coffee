package kr.or.dgit.jdbc_coffee.dao;

import java.sql.SQLException;

public abstract class AbstractDao<T> {
	public abstract void insertItem(T item) throws SQLException;
}
