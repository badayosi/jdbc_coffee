package kr.or.dgit.jdbc_coffee.view;

import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;

import kr.or.dgit.jdbc_coffee.component.ComboBoxComponent;
import kr.or.dgit.jdbc_coffee.component.TextFieldComponent;
import kr.or.dgit.jdbc_coffee.dao.IncomeDao;
import kr.or.dgit.jdbc_coffee.dao.ProductDao;
import kr.or.dgit.jdbc_coffee.dao.SaleDao;
import kr.or.dgit.jdbc_coffee.dto.Income;
import kr.or.dgit.jdbc_coffee.dto.Product;
import kr.or.dgit.jdbc_coffee.dto.Sale;

@SuppressWarnings("serial")
public class InputView extends JPanel {
	private ComboBoxComponent<Product> pCode;
	private ProductDao pdtDao = ProductDao.getInstance();
	private	IncomeDao incDao = IncomeDao.getInstance();
	private	SaleDao salDao = SaleDao.getInstance();
	private TextFieldComponent pName;
	private TextFieldComponent pPrice;
	private TextFieldComponent pCount;
	private TextFieldComponent pMargin;

	public InputView() {
		setLayout(new GridLayout(0, 2, 0, 0));
		
		pName = new TextFieldComponent("제품명", 10);
		pName.setEnable(false);
		
		pPrice = new TextFieldComponent("단가", 8);
		pCount = new TextFieldComponent("수량", 8);
		pMargin = new TextFieldComponent("마진율", 3);
		
		pCode = new ComboBoxComponent<>("제품코드");
		pCode.setParentPanel(this);
		try {
			setProduct();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		add(pCode);
		add(pName);
		add(pPrice);
		
		//공백용 패널
		JPanel pNone1 = new JPanel();
		add(pNone1);
				
		add(pCount);
		
		//공백용 패널
		JPanel pNone2 = new JPanel();
		add(pNone2);
				
		add(pMargin);
		
		//공백용 패널
		JPanel pNone3 = new JPanel();
		add(pNone3);
	}

	private void setProduct() throws SQLException{
		List<Product> lists = pdtDao.AllProduct();
		Vector<Product> vLists = new Vector<>(lists);
		pCode.setModel(vLists);
		pName.setText(vLists.get(0).getpName());
		loadInfo(vLists.get(0).getpCode());
	}
	
	private void loadInfo(String code) throws SQLException {
		Income incTemp = incDao.selectItemByCode(new Income(code));
		Sale salTemp = salDao.selectItemByCode(new Sale(code));
		
		pPrice.setText(String.valueOf(incTemp.getpPrice()));
		pMargin.setText(String.valueOf(incTemp.getpMargin()));
		pCount.setText(String.valueOf(salTemp.getsCount()));
	}

	public void changeNameField(Object selectedItem) throws SQLException {
		Product temp = (Product)selectedItem;
		pName.setText(temp.getpName());
		loadInfo(temp.getpCode());
	}

	public void updateData() throws SQLException {
		String upCode = pCode.getProductCode();
		int upPrice = Integer.valueOf(pPrice.getText());
		int upMargin = Integer.valueOf(pMargin.getText());
		int upCount = Integer.valueOf(pCount.getText());
		
		Income incTemp = new Income(upCode, upPrice, upMargin);
		incDao.updateItem(incTemp);
		Sale saleTemp = new Sale(upCode, upCount);
		salDao.updateItem(saleTemp);
		viewClear();
	}

	public void viewClear() {
		pPrice.clear();
		pMargin.clear();
		pCount.clear();
	}
}
