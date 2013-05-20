package app.bsodsoftware.gameclub.java.gui.tablas;

import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

public class TablaPrestamos extends JTable {

	private static final long serialVersionUID = 6115560306703962276L;

	ModeloJuego modelo;
	TableRowSorter<ModeloJuego> sorter;

	public TablaPrestamos(ModeloJuego model) {

		modelo = model;

		init();
	}

	private void init() {
		setRowHeight(56);

		setModel(modelo);

		setAutoCreateRowSorter(true);

		setShowGrid(true);
		
		
		
		crearSorter();
	}

	private void crearSorter() {

		sorter = new TableRowSorter<ModeloJuego>(modelo);

		setRowSorter(sorter);
	}

	public void newFilter(String text) {
		
	    RowFilter<ModeloJuego, Object> rf = null;
	    //If current expression doesn't parse, don't update.
	    
	    try {
	    	
	    	String expresionRegular = "";
	    	
	    	if ( !"".equals(text)) expresionRegular = "^.*REG.*$".replace("REG", text);
	    	
	        rf = RowFilter.regexFilter(expresionRegular, 0);
	        
	    } catch (java.util.regex.PatternSyntaxException e) { return; }
	    
	    
	    sorter.setRowFilter(rf);
	}

	public TableRowSorter<ModeloJuego> getSorter() {
		return sorter;
	}
}
