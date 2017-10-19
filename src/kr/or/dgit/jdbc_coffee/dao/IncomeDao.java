package kr.or.dgit.jdbc_coffee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			pstmt.setString(1, item.getpCode());
			pstmt.setInt(2, item.getpPrice());
			pstmt.setInt(3, item.getpMargin());
			pstmt.executeUpdate();
		}
	}

	@Override
	public Income selectItemByCode(Income item) throws SQLException {
		String sql = "SELECT * FROM jdbc_coffee.income WHERE pcode = ?";
		Income inc = null;
		try(PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql);){
			pstmt.setString(1, item.getpCode());
			try(ResultSet rs = pstmt.executeQuery();){
				if(rs.next()){
					inc = getIncome(rs); 
				}
			}
		}
		return inc;
	}
	
	@Override
	public void updateItem(Income item) throws SQLException {
		String sql = "UPDATE income SET pPrice=?, pMargin=? WHERE pcode=?";
		Connection con = DBCon.getInstance().getConnection();
		try(PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setInt(1, item.getpPrice());
			pstmt.setInt(2, item.getpMargin());
			pstmt.setString(3, item.getpCode());
			pstmt.executeUpdate();
		}
	}

	private Income getIncome(ResultSet rs) throws SQLException{
		String pCode = rs.getString("pCode");
		int pPrice = rs.getInt("pPrice");
		int pMargin = rs.getInt("pMargin");
		return new Income(pCode, pPrice, pMargin);
	}

	
}
