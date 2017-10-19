package kr.or.dgit.jdbc_coffee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			pstmt.setString(1, item.getpCode());
			pstmt.setInt(2, item.getsCount());
			pstmt.executeUpdate();
		}
	}

	@Override
	public Sale selectItemByCode(Sale item) throws SQLException {
		String sql = "SELECT pcode,scount FROM sale WHERE pCode = ?";
		Connection con = DBCon.getInstance().getConnection();
		Sale sale = null;
		
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, item.getpCode());
			try(ResultSet rs = pstmt.executeQuery();){
				if(rs.next()){
					sale = getSale(rs); 
				}
			}
		}
		return sale;
	}
	
	@Override
	public void updateItem(Sale item) throws SQLException {
		String sql = "UPDATE sale SET scount=? WHERE pcode=?";
		Connection con = DBCon.getInstance().getConnection();
		try(PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setInt(1, item.getsCount());
			pstmt.setString(2, item.getpCode());
			pstmt.executeUpdate();
		}
	}

	private Sale getSale(ResultSet rs) throws SQLException {
		String pCode = rs.getString("pCode");
		int sCount = rs.getInt("sCount");
		return new Sale(pCode, sCount);
	}
}
