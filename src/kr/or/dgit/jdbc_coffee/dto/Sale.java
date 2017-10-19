package kr.or.dgit.jdbc_coffee.dto;

public class Sale {
	private String pCode;
	private int sCount;
	
	//생성자
	public Sale() {
		
	}
	
	public Sale(String pCode) {
		this.pCode = pCode;
	}
	
	public Sale(String pCode, int sCount) {
		this.pCode = pCode;
		this.sCount = sCount;
	}

	//메소드
	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public int getsCount() {
		return sCount;
	}

	public void setsCount(int sCount) {
		this.sCount = sCount;
	}

	//ToString
	@Override
	public String toString() {
		return String.format("Sale [pCode=%s, sCount=%s]", pCode, sCount);
	}
}
