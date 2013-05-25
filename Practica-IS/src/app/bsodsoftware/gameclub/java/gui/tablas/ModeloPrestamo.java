package app.bsodsoftware.gameclub.java.gui.tablas;

import javax.swing.table.AbstractTableModel;

import app.bsodsoftware.gameclub.java.entidades.prestar.Prestamo;

/**
 * Un modelo para las tablas.
 * 
 * @author Daniel Serrano Torres
 * @author Alvaro Quesada Pimentel
 * @author Juan Prérez Valbuena
 * @author Emilio Alvarez
 */
public class ModeloPrestamo extends AbstractTableModel {

	private static final long serialVersionUID = -6900850597743594873L;
	
	private int numColum;
	private int numFilas;
	private Prestamo[] prestamos;
	
	/**
	 * Columnas predefinidas del modelo para los juegos.
	 */
	public final static String[] columnas = { "DNI", "Nombre usuario", "Juego",
			"Fecha de prestamo", "Fecha de devolución" };
	
	/**
	 * Crea un contenedor de juegos para una tabla.
	 * @param prestamosNuevos Nueva lista de juegos
	 * @param columnas Nombres de las columnas.
	 */
	public ModeloPrestamo(Prestamo[] prestamosNuevos, String[] columnas) {
		numColum = columnas.length;
		numFilas = prestamosNuevos.length;
		prestamos = prestamosNuevos;
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
		
		if (prestamos.length > 0) {
			switch (column) {
			case 0:
				dato = prestamos[row].getUsuario_a_prestar().getDni();
				break;
				
			case 1:
				dato = prestamos[row].getUsuario_a_prestar().getNombre();
				break;
				
			case 2:
				dato = prestamos[row].getJuego_a_prestar().getNombre();
				break;
				
			case 3:
				dato = prestamos[row].getFecha_de_prestamos();
				break;
				
			case 4:
				dato = prestamos[row].getFecha_a_devolver();
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
	public void setObjetos(Prestamo[] juegosNuevos) {
		prestamos = juegosNuevos;
		numFilas = prestamos.length;
	}
	
	/**
	 * Método que rellena los datos en la tabla.
	 */
	public void rellenar() {
		
		for (int i = 0; i < prestamos.length; i++) {
			setValueAt(prestamos[i].getUsuario_a_prestar().getDni(), i, 0);
			setValueAt(prestamos[i].getUsuario_a_prestar().getNombre(), i, 1);
			setValueAt(prestamos[i].getJuego_a_prestar().getNombre(), i, 2);
			setValueAt(prestamos[i].getFecha_de_prestamos(), i, 3);
			setValueAt(prestamos[i].getFecha_a_devolver(), i, 4);
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
	
	/**
	 * Método que obtiene un juego a partir de una fila.
	 * @param fila Fila de la tabla que tenga el modelo.
	 * @return El juego.
	 */
	public Prestamo getPrestamo(int fila) {
		
		Prestamo prestamo = null;
		
		if (fila <= prestamos.length) {
			prestamo = prestamos[fila];
		}
		
		return prestamo;
	}
}
