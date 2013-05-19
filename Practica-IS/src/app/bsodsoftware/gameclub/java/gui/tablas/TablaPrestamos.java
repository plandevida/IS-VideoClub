package app.bsodsoftware.gameclub.java.gui.tablas;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class TablaPrestamos extends JTable {

	private static final long serialVersionUID = 6115560306703962276L;
	
	AbstractTableModel modelo;
	
	public TablaPrestamos(AbstractTableModel model) {
		
		super(model);
		
		modelo = model;
		
		cambiarTamFilas();
	}
	
	private void cambiarTamFilas() {
		setRowHeight(56);
	}
	
	public JScrollPane comoPanelScrolable() {
		
		JScrollPane scrollPanel = new JScrollPane(this);
		
		return scrollPanel;
	}
}
