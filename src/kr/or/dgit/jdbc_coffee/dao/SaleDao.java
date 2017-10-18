package kr.or.dgit.jdbc_coffee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.or.dgit.jdbc_coffee.dto.Sale;
import kr.or.dgit.jdbc_setting.jdbc.DBCon;

public class SaleDao extends AbstractDao<Sale>{
	private static final SaleDao instance = new SaleDao();
	
	//싱글패턴
	public static SaleDao getInstance(){
		return instance;
	}
	
	//생성자
	private SaleDao(){}
	
	//DAO메소드
	@Override
	public void insertItem(Sale item) throws SQLException{
		String sql = "INSERT INTO sale(pCode, sCount) VALUES(?, ?)";
		Connection con = DBCon.getInstance().getConnection();
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(0, item.getpCode());
			pstmt.setInt(1, item.getsCount());
		}
	}
}
