package app.bsodsoftware.gameclub.java.gui.paneles;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTable;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Dimension;

public class PrestamosPanel extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PrestamosPanel() {
		setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		add(table, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(300, 10));
		add(panel, BorderLayout.EAST);
		panel.setLayout(new FormLayout(new ColumnSpec[] {},
			new RowSpec[] {}));

	}

}
