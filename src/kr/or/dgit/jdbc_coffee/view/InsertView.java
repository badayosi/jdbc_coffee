package kr.or.dgit.jdbc_coffee.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.jdbc_coffee.component.TextFieldComponent;
import kr.or.dgit.jdbc_coffee.dao.ProductDao;
import kr.or.dgit.jdbc_coffee.dto.Product;

@SuppressWarnings("serial")
public class InsertView extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JButton btnOK;
	private TextFieldComponent pCode;
	private TextFieldComponent pName;

	public InsertView() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 300, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		pCode = new TextFieldComponent("제품코드", 5);
		contentPane.add(pCode);
		
		pName = new TextFieldComponent("제품이름", 10);
		contentPane.add(pName);
		
		JPanel pBtn = new JPanel();
		contentPane.add(pBtn);
		pBtn.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnOK = new JButton("추가");
		btnOK.addActionListener(this);
		pBtn.add(btnOK);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOK) {
			try {
				ProductDao.getInstance().insertItem(new Product(pCode.getText(), pName.getText()));
				JOptionPane.showMessageDialog(null, "제품추가가 완료되었습니다");
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "제품코드가 이미 존재합니다");
			}
		}
	}
}
