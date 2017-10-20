package kr.or.dgit.jdbc_coffee.view;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.jdbc_coffee.list.ListSaleRank;

@SuppressWarnings("serial")
public class OutputView extends JFrame {

	private JPanel contentPane;
	private ListSaleRank panel;

	public OutputView(String str) {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 700, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		if(str.equals("판매순위"))
			panel = new ListSaleRank(str);
		else if(str.equals("마진순위"))
			panel = new ListSaleRank(str);
		else
			JOptionPane.showMessageDialog(null, "생성실패");
		
		panel.loadData();
			
		contentPane.add(panel);
	}

}
