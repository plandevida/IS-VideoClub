package app.bsodsoftware.gameclub.java.gui.tablas.modelos;

import javax.swing.table.AbstractTableModel;

import app.bsodsoftware.gameclub.java.entidades.juego.Juego;

/**
 * Un modelo para las tablas.
 * 
 * @author Daniel Serrano Torres
 * @author Alvaro Quesada Pimentel
 * @author Juan Prérez Valbuena
 * @author Emilio Alvarez
 */
public class ModeloJuego extends AbstractTableModel implements MiModelo {

	private static final long serialVersionUID = -6900850597743594873L;
	
	private int numColum;
	private int numFilas;
	private Juego[] juegos;
	
	/**
	 * Columnas predefinidas del modelo para los juegos.
	 */
	private String[] columnas = { "Nombre", "Número de jugadores", "Edad mínima",
			"Descripción", "Imagen" };
	
	public ModeloJuego() {
		init(new Juego[]{});
	}
	
	/**
	 * Crea un contenedor de juegos para una tabla.
	 * @param juegosNuevos Nueva lista de juegos
	 * @param columnas Nombres de las columnas.
	 */
	public ModeloJuego(Juego[] juegosNuevos, String[] columnas) {
		init(juegosNuevos);
	}
	
	private void init(Juego[] juegosNuevos) {
		numColum = columnas.length;
		numFilas = juegosNuevos.length;
		juegos = juegosNuevos;
	}
	
	@Override
	
	/**
	 * Obtiene el número de columnas.
	 */
	public int getColumnCount() {
		
		return numColum;
	}

	@Override
	
	/**
	 * Obtiene el número de filas.
	 */
	public int getRowCount() {
		
		return numFilas;
	}

	@Override
	
	/**
	 * Este método devuelve el dato de cada celda.
	 */
	public Object getValueAt(int row, int column) {
		
		Object dato = null;
		
		if (juegos.length > 0) {
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
		}
		
		return dato;
	}
	
	/**
	 * Método que cambia los datos de la tabla.
	 * @param juegosNuevos Nueva lista de datos.
	 */
	public void setObjetos(Juego[] juegosNuevos) {
		juegos = juegosNuevos;
		numFilas = juegos.length;
	}
	
	/**
	 * Método que rellena los datos en la tabla.
	 */
	@Override
	public void rellenar() {
		
		for (int i = 0; i < juegos.length; i++) {
			setValueAt(juegos[i].getNombre(), i, 0);
			setValueAt(juegos[i].getNum_jugadores(), i, 1);
			setValueAt(juegos[i].getEdad_minima(), i, 2);
			setValueAt(juegos[i].getDescripcion(), i, 3);
			setValueAt(juegos[i].getImagen(), i, 4);
		}
		
		fireTableDataChanged();
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
	
	/**
	 * Método que obtiene un juego a partir de una fila.
	 * @param fila Fila de la tabla que tenga el modelo.
	 * @return El juego.
	 */
	public Juego getJuego(int fila) {
		
		Juego juego = null;
		
		if (fila <= juegos.length) {
			juego = juegos[fila];
		}
		
		return juego;
	}

	@Override
	public String[] getColumnas() {
		
		return columnas;
	}
}
