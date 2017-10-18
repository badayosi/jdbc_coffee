package kr.or.dgit.jdbc_coffee.dto;

public class Product {
	private String pCode;
	private String pName;

	// 생성자
	public Product() {

	}

	public Product(String pCode) {
		this.pCode = pCode;
	}

	public Product(String pCode, String pName) {
		this.pCode = pCode;
		this.pName = pName;
	}

	// 메소드
	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	// ToString
	@Override
	public String toString() {
		return String.format("%s", pCode);
	}
}
