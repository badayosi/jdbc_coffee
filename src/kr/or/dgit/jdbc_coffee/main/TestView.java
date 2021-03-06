package kr.or.dgit.jdbc_coffee.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.jdbc_coffee.view.InputView;
import javax.swing.JButton;
import kr.or.dgit.jdbc_coffee.view.ButtonView;

@SuppressWarnings("serial")
public class TestView extends JFrame {
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestView frame = new TestView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TestView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		InputView pCenter = new InputView();
		contentPane.add(pCenter, BorderLayout.CENTER);
		
		ButtonView panel = new ButtonView(pCenter);
		contentPane.add(panel, BorderLayout.SOUTH);
	}

}
