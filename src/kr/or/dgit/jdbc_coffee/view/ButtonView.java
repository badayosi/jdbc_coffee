package kr.or.dgit.jdbc_coffee.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ButtonView extends JPanel implements ActionListener {
	private JButton btnCancle;
	private JButton btnInput;
	private JButton btnNewProduct;
	private JButton btnPrintMargin;
	private JButton btnPrintPrice;
	private InputView inView;

	public ButtonView(InputView pCenter) {
		inView = pCenter;
		setLayout(new GridLayout(0, 5, 10, 10));

		btnInput = new JButton("입력");
		btnInput.addActionListener(this);
		add(btnInput);

		btnCancle = new JButton("취소");
		btnCancle.addActionListener(this);
		add(btnCancle);

		btnNewProduct = new JButton("추가");
		btnNewProduct.addActionListener(this);
		add(btnNewProduct);

		btnPrintPrice = new JButton("판매순위");
		btnPrintPrice.addActionListener(this);
		add(btnPrintPrice);

		btnPrintMargin = new JButton("마진순위");
		btnPrintMargin.addActionListener(this);
		add(btnPrintMargin);

	}

	public void actionPerformed(ActionEvent e) {
		if ((e.getSource() == btnPrintPrice) || e.getSource() == btnPrintMargin) {
			OutputView SaleRank = new OutputView(e.getActionCommand());
			SaleRank.setVisible(true);
		}
		if (e.getSource() == btnNewProduct) {
			InsertView newProduct = new InsertView();
			newProduct.setVisible(true);
		}
		if (e.getSource() == btnInput) {
			try {
				inView.updateData();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		if (e.getSource() == btnCancle) {
			inView.viewClear();
		}
	}
}
