package kr.or.dgit.jdbc_coffee.dto;

public class Income {
	private String pCode;
	private int pPrice;
	private int pMargin;

	// 생성자
	public Income() {

	}

	// 메소드
	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public int getpPrice() {
		return pPrice;
	}

	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}

	public int getpMargin() {
		return pMargin;
	}

	public void setpMargin(int pMargin) {
		this.pMargin = pMargin;
	}

	// ToString
	@Override
	public String toString() {
		return String.format("Income [pCode=%s, pPrice=%s, pMargin=%s]", pCode, pPrice, pMargin);
	}
}
