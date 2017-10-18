package kr.or.dgit.jdbc_coffee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.or.dgit.jdbc_coffee.dto.Income;
import kr.or.dgit.jdbc_setting.jdbc.DBCon;

public class IncomeDao extends AbstractDao<Income>{
	private static final IncomeDao instance = new IncomeDao();
	
	//싱글패턴
	public static IncomeDao getInstance(){
		return instance;
	}
	
	//생성자
	private IncomeDao(){}
	
	//DAO메소드
	@Override
	public void insertItem(Income item) throws SQLException{
		String sql = "INSERT INTO Income(pdtprice, pdtMargin, pdtNo) VALUES(?, ?, ?)";
		Connection con = DBCon.getInstance().getConnection();
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(0, item.getpCode());
			pstmt.setInt(1, item.getpPrice());
			pstmt.setInt(2, item.getpMargin());
		}
	}
}
