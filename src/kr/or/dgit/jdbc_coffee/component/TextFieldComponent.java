package kr.or.dgit.jdbc_coffee.component;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class TextFieldComponent extends JPanel{
	private JTextField textField;
	
	//생성자
	public TextFieldComponent(String text, int column) {
		setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel(text);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel);
		
		textField = new JTextField();
		add(textField);
		textField.setColumns(column);
	}
	
	//메소드
	public void isEmptyCheck() throws Exception{
		if (getTextValue().equals("")){
			textField.requestFocus();
			throw new Exception("공백 존재");
		}
	}

	private String getTextValue() {
		return textField.getText().trim();
	}

	public JTextField getTextField() {
		return textField;
	}
	
	public String getText() {
		return textField.getText();
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
	
	public void setText(String str) {
		textField.setText(str);
	}
	
	public void setEnable(boolean set){
		this.textField.setEnabled(set);
	}
	
	public void clear(){
		textField.setText("");
	}
}
