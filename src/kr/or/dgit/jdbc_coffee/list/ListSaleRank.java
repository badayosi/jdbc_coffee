package kr.or.dgit.jdbc_coffee.list;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import kr.or.dgit.jdbc_coffee.dao.IncomeDao;
import kr.or.dgit.jdbc_coffee.dao.ProductDao;
import kr.or.dgit.jdbc_coffee.dao.SaleDao;
import kr.or.dgit.jdbc_coffee.dto.Income;
import kr.or.dgit.jdbc_coffee.dto.Product;
import kr.or.dgit.jdbc_coffee.dto.Rank;
import kr.or.dgit.jdbc_coffee.dto.Sale;

@SuppressWarnings("serial")
public class ListSaleRank extends AbstractList {
	private ProductDao pDao;
	private IncomeDao iDao;
	private SaleDao sDao;
	private String type;

	public ListSaleRank(String str) {
		this.pDao = ProductDao.getInstance();
		this.iDao = IncomeDao.getInstance();
		this.sDao = SaleDao.getInstance();
		this.type = str;
	}

	@Override
	protected void setAlignWidth() {
		setCellWidth(50, 100, 200, 100, 100, 200, 200, 200, 100, 150);
		setAlign(SwingConstants.CENTER, 0, 1, 2);//
		setAlign(SwingConstants.RIGHT, 3, 4, 5, 6, 7, 8, 9);
	}

	@Override
	protected Object[][] getData() {
		List<Rank> lists = makeTotalLists(type);
		sortByType(lists);

		Object[][] datas = new Object[lists.size()][];
		for (int i = 0; i < lists.size(); i++) {
			Rank rTemp = lists.get(i);
			datas[i] = rTemp.toArray();
		}
		return datas;
	}

	@Override
	protected String[] getColumnNames() {
		return new String[] { "순위", "제품코드", "제품명", "제품단가", "판매수량", "공급가액", "부가세액", "판매금액", "마진율", "마진액" };
	}

	@Override
	public Object getSelectedItem() {
		// TODO Auto-generated method stub
		return null;
	}

	private List<Rank> makeTotalLists(String type) {
		List<Rank> lists = new ArrayList<>();
		List<Product> pTemp = null;
		List<Income> iTemp = null;
		List<Sale> sTemp = null;
		try {
			pTemp = pDao.selectItemAll();
			iTemp = iDao.selectItemAll();
			sTemp = sDao.selectItemAll();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "리스트 로딩 실패");
		}
		for (int index = 0; index < pTemp.size(); index++) {
			int pRank = 0;
			String pCode = pTemp.get(index).getpCode();
			String pName = pTemp.get(index).getpName();
			int pPrice = iTemp.get(index).getpPrice();
			int pMargin = iTemp.get(index).getpMargin();
			int sCount = sTemp.get(index).getsCount();
			lists.add(new Rank(pRank, pCode, pName, pPrice, pMargin, sCount, type));
		}
		return lists;
	}

	private List<Rank> sortByType(List<Rank> lists) {
		Collections.sort(lists);
		return lists;
	}
}
