package app.bsodsoftware.gameclub.java.gui.tablas;

import javax.swing.table.AbstractTableModel;

import app.bsodsoftware.gameclub.java.entidades.juego.Juego;

public class ModeloJuego extends AbstractTableModel {

	private static final long serialVersionUID = -6900850597743594873L;
	
	private int numColum;
	private int numFilas;
	private Juego[] juegos;
	
	public final static String[] columnas = { "Nombre", "Número de jugadores", "Edad mínima",
			"Descripción", "Imagen" };
	
	/**
	 * MiJTable construction with a ItemContainer
	 * @param obj
	 */
	public ModeloJuego(Juego[] juegosNuevos, String[] columnas) {
		numColum = columnas.length;
		numFilas = juegosNuevos.length;
		juegos = juegosNuevos;
	}
	
	@Override
	
	/**
	 * This method returns number of columns
	 */
	public int getColumnCount() {
		
		return numColum;
	}

	@Override
	
	/**
	 * This method returns number of rows
	 */
	public int getRowCount() {
		
		return numFilas;
	}

	@Override
	
	/**
	 * This method returns object�ID or the Object�Description or null.
	 */
	public Object getValueAt(int row, int column) {
		
		Object dato = null;
		
		switch (column) {
		case 0:
			dato = juegos[row].getNombre();
			break;
			
		case 1:
			dato = juegos[row].getNum_jugadores();
			break;
			
		case 2:
			dato = juegos[row].getEdad_minima();
			break;
			
		case 3:
			dato = juegos[row].getDescripcion();
			break;
			
		case 4:
			dato = juegos[row].getImagen(); 
			break;
		default:
			dato = "";
			break;
		}
		
		return dato;
	}
	
	/**
	 * This method changes the ItemContainer and changes the number of row by the number of items.
	 * @param a - The ItemContainer to change.
	 */
	public void setObjetos(Juego[] juegosNuevos) {
		juegos = juegosNuevos;
		numFilas = juegos.length;
	}
	
	/**
	 * This method Complete the JTble with the items of ItemContainer.
	 */
	public void rellenar() {
		
		for (int i = 0; i < juegos.length; i++) {
			setValueAt(juegos[i].getNombre(), i, 0);
			setValueAt(juegos[i].getNum_jugadores(), i, 1);
			setValueAt(juegos[i].getEdad_minima(), i, 2);
			setValueAt(juegos[i].getDescripcion(), i, 3);
			setValueAt(juegos[i].getImagen(), i, 4);
		}
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
}
