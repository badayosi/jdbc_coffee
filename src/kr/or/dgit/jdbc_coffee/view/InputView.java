package kr.or.dgit.jdbc_coffee.view;

import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;

import kr.or.dgit.jdbc_coffee.component.ComboBoxComponent;
import kr.or.dgit.jdbc_coffee.component.TextFieldComponent;
import kr.or.dgit.jdbc_coffee.dao.ProductDao;
import kr.or.dgit.jdbc_coffee.dto.Product;

@SuppressWarnings("serial")
public class InputView extends JPanel {
	private ComboBoxComponent<Product> pCode;
	private ProductDao pdtDao = ProductDao.getInstance();
	private TextFieldComponent pName;

	public InputView() {
		setLayout(new GridLayout(0, 2, 0, 0));
		
		pName = new TextFieldComponent("제품명", 10);
		pName.setEnable(false);
		
		pCode = new ComboBoxComponent<>("제품코드");
		pCode.setParentPanel(this);
		try {
			setProduct();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		add(pCode);
		add(pName);
		
		TextFieldComponent pPrice = new TextFieldComponent("단가", 8);
		add(pPrice);
		
		//공백용 패널
		JPanel pNone1 = new JPanel();
		add(pNone1);
		
		TextFieldComponent pCount = new TextFieldComponent("수량", 8);
		add(pCount);
		
		//공백용 패널
		JPanel pNone2 = new JPanel();
		add(pNone2);
		
		TextFieldComponent pMargin = new TextFieldComponent("마진율", 3);
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
	}

	public void changeNameField(Object selectedItem) {
		Product temp = (Product)selectedItem;
		pName.setText(temp.getpName());
	}
}
