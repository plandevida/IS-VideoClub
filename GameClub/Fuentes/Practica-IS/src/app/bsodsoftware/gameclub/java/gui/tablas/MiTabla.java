package app.bsodsoftware.gameclub.java.gui.tablas;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

import app.bsodsoftware.gameclub.java.gui.tablas.modelos.MiModelo;

/**
 * Una tabla que permite filtrar el contenido
 * 
 * @author Daniel Serrano Torres
 * @author Alvaro Quesada Pimentel
 * @author Juan Prérez Valbuena
 * @author Emilio Alvarez
 */
public class MiTabla extends JTable {

	private static final long serialVersionUID = 6115560306703962276L;

	AbstractTableModel modelo;
	TableRowSorter<AbstractTableModel> sorter;

	public MiTabla(AbstractTableModel model) {

		modelo = model;

		init();

	}

	private void init() {
		setRowHeight(56);

		setModel(modelo);

		setAutoCreateRowSorter(true);

		setShowGrid(true);

		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		setNombreColumnas();

		crearSorter();

	}

	private void crearSorter() {

		sorter = new TableRowSorter<AbstractTableModel>(modelo);

		setRowSorter(sorter);
	}

	public void filtrar(String text, int columnaDondeFiltrar) {

		RowFilter<? super AbstractTableModel, ? super Integer> rf = null;
		// If current expression doesn't parse, don't update.

		try {

			String expresionRegular = "";

			if (!"".equals(text))
				expresionRegular = "^.*?\\bREG\\b.*$".replace("REG", text);

			rf = RowFilter.regexFilter(expresionRegular, columnaDondeFiltrar);

		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}

		sorter.setRowFilter(rf);
	}

	public TableRowSorter<AbstractTableModel> getSorter() {
		return sorter;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int colIndex) {
		return false;
	}

	/**
	 * Asigna el nombre a las columnas del modelo
	 * 
	 */
	private void setNombreColumnas() {

		JTableHeader cabecera = getTableHeader();
		TableColumnModel modeloColumna = cabecera.getColumnModel();
		TableColumn columna;

		String[] columnasModelo = ((MiModelo<?>) getModel()).getColumnas();

		for (int i = 0; i < modelo.getColumnCount(); i++) {

			columna = modeloColumna.getColumn(i);
			columna.setHeaderValue(columnasModelo[i]);
		}
		cabecera.repaint();

	}
}
