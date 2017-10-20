package kr.or.dgit.jdbc_coffee.list;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

@SuppressWarnings("serial")
public abstract class AbstractList extends JPanel {
	protected JTable table;

	public AbstractList() {
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		scrollPane.setViewportView(table);

	}

	public void loadData() {
		DefaultTableModel model = new DefaultTableModel(getData(), getColumnNames());
		table.setModel(model);
		setAlignWidth();
	}

	protected abstract void setAlignWidth();

	protected void setCellWidth(int... width) {
		TableColumnModel cModel = table.getColumnModel();
		for (int i = 0; i < width.length; i++) {
			cModel.getColumn(i).setPreferredWidth(width[i]);
		}
	}

	protected void setAlign(int align, int... idx) {
		// 0번 컬럼을 정렬(Left, Right, Center)
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);

		TableColumnModel cModel = table.getColumnModel();
		// idx = [0,2]
		for (int i = 0; i < idx.length; i++) {
			cModel.getColumn(idx[i]).setCellRenderer(dtcr);
		}

	}

	protected abstract Object[][] getData();

	protected abstract String[] getColumnNames();

	public abstract Object getSelectedItem();
}
