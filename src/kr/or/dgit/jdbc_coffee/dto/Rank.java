package kr.or.dgit.jdbc_coffee.dto;

public class Rank implements Comparable<Rank>{
	private int pRank;
	private String pCode;
	private String pName;
	private int pPrice;
	private int pMargin;
	private int sCount;
	
	private int vSupply; //공급가액
	private int vSurtax; //부가세액
	private int vSaleprice; //판매금액
	private int vMargin; //마진액
	
	private String type;
	
	//생성자
	public Rank() {
		
	}

	public Rank(int vSupply, int vSurtax, int vSaleprice, int vMargin, String type) {
		this.vSupply = vSupply;
		this.vSurtax = vSurtax;
		this.vSaleprice = vSaleprice;
		this.vMargin = vMargin;
		this.type = type;
	}

	public Rank(int pRank, String pCode, String pName, int pPrice, int pMargin, int sCount, String type) {
		this.pRank = pRank;
		this.pCode = pCode;
		this.pName = pName;
		this.pPrice = pPrice;
		this.pMargin = pMargin;
		this.sCount = sCount;
		this.type = type;
		valueCalc();
	}

	//메소드
	private void valueCalc() {
		this.vSaleprice = this.pPrice * this.sCount;
		this.vSurtax = (int)Math.ceil(this.vSaleprice / 11);
		this.vSupply = this.vSaleprice - this.vSurtax;
		this.vMargin = Math.round(this.vSupply * this.pMargin);
	}
	
	public void setpRank(int pRank) {
		this.pRank = pRank;
	}
	
	public int getvSupply() {
		return vSupply;
	}

	public void setvSupply(int vSupply) {
		this.vSupply = vSupply;
	}

	public int getvSurtax() {
		return vSurtax;
	}

	public void setvSurtax(int vSurtax) {
		this.vSurtax = vSurtax;
	}

	public int getvSaleprice() {
		return vSaleprice;
	}

	public void setvSaleprice(int vSaleprice) {
		this.vSaleprice = vSaleprice;
	}

	public int getvMargin() {
		return vMargin;
	}

	public void setvMargin(int vMargin) {
		this.vMargin = vMargin;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Object[] toArray() {
		return new Object[]{
				pRank,
				pCode,
				pName,
				pPrice,
				sCount,
				vSupply,
				vSurtax,
				vSaleprice,
				pMargin,
				vMargin
		};
	}

	@Override
	public int compareTo(Rank o) {
		if(this.type.equals("판매순위")){
			if(this.vSaleprice < o.vSaleprice)
				return 1;
			else if(this.vSaleprice > o.vSaleprice)
				return -1;
			else
				return 0;
		}
		if(this.type.equals("마진순위")){
			if(this.vMargin < o.vMargin)
				return 1;
			else if(this.vMargin > o.vMargin)
				return -1;
			else
				return 0;
		}
		return 0;
	}
}
