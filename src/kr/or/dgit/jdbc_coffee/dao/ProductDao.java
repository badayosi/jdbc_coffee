package kr.or.dgit.jdbc_coffee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.dgit.jdbc_coffee.dto.Product;
import kr.or.dgit.jdbc_setting.jdbc.DBCon;

public class ProductDao extends AbstractDao<Product>{
	private static final ProductDao instance = new ProductDao();
	
	//싱글패턴
	public static ProductDao getInstance(){
		return instance;
	}
	
	//생성자
	private ProductDao(){}
	
	//DAO메소드
	@Override
	public void insertItem(Product item) throws SQLException{
		String sql = "INSERT INTO product(pcode, pname) VALUES(?, ?)";
		Connection con = DBCon.getInstance().getConnection();
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, item.getpCode());
			pstmt.setString(2, item.getpName());
			pstmt.executeUpdate();
		}
	}
	
	@Override
	public Product selectItemByCode(Product item) throws SQLException {
		
		return null;
	}
	
	@Override
	public void updateItem(Product item) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	private Product getProduct(ResultSet rs) throws SQLException{
		String pCode = rs.getString("pCode");
		String pName = rs.getString("pName");
		return new Product(pCode, pName);
	}
	
	public List<Product> AllProduct() throws SQLException{
		String sql = "SELECT * FROM product";
		List<Product> lists = new ArrayList<>();
		try(PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql);){
			try(ResultSet rs = pstmt.executeQuery();){
				while(rs.next()){
					lists.add(getProduct(rs));
				}
			}
		}
		return lists;
	}
}
