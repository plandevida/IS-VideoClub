package app.bsodsoftware.gameclub.java.gui.tablas;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

import app.bsodsoftware.gameclub.java.entidades.juego.Juego;

public class ModeloJuego extends AbstractTableModel {

	private static final long serialVersionUID = -7174921828122713554L;
	
	private String[] columnas;
	private Juego[] filas;

	public ModeloJuego(Juego[] data, String[] columns) {

		columnas = columns;
		filas = data;
	}

	@Override
	public int getRowCount() {
		return filas.length;
	}

	@Override
	public int getColumnCount() {
		return columnas.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Juego juego = filas[rowIndex];
		
		Object datoColumna = datoJuego(columnIndex, juego);
		
		return datoColumna;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return columnas[columnIndex].toString();
	}

	@Override
	public void setValueAt(Object value, int rowIndex, int columnIndex) {

		cambiaDatoJuego(columnIndex, filas[rowIndex], value);
		fireTableCellUpdated(rowIndex, columnIndex);
	}

	@Override
	public Class<?> getColumnClass(int c) {
		Class<?> clazz = Object.class;
		Object aux = getValueAt(0, c);
		if (aux != null) {
			clazz = aux.getClass();
		}

		return clazz;
	}
	
	private void cambiaDatoJuego(int columna, Juego juego, Object dato) {
		
		switch(columna) {
		
		case 0:
			juego.setNombre( (String)dato );
			break;
		case 1:
			juego.setComentarios( (String)dato );
			break;
		case 2:
			juego.setImagen( (ImageIcon)dato );
			break;
		}
	}
	
	private Object datoJuego(int columna, Juego juego) {
		
		Object datoColumna;
		
		switch(columna) {
		
		case 0:
			datoColumna = juego.getNombre();
			break;
		case 1:
			datoColumna = juego.getImagen();
			break;
		case 2:
			datoColumna = juego.getComentarios();
			break;
		default:
			datoColumna = "";
		}
		
		return datoColumna;
	}
}
