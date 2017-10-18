package kr.or.dgit.jdbc_coffee.component;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

import kr.or.dgit.jdbc_coffee.view.InputView;

@SuppressWarnings("serial")
public class ComboBoxComponent<T> extends JPanel {
	private JComboBox<T> comboBox;
	private InputView parentPanel;
			
	public ComboBoxComponent(String text) {
		setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel = new JLabel(text);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel);
		
		comboBox = new JComboBox<>();
		add(comboBox);
		
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==comboBox){
					parentPanel.changeNameField(comboBox.getSelectedItem());
				}
			}
		});
	}
	
	public void setModel(Vector<T> item){
		ComboBoxModel<T> model = new DefaultComboBoxModel<>(item);
		comboBox.setModel(model);
	}

	public void setParentPanel(InputView parentPanel) {
		this.parentPanel = parentPanel;
	}
}
