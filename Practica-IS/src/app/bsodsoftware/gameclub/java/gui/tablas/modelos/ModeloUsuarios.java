package app.bsodsoftware.gameclub.java.gui.tablas.modelos;

import javax.swing.table.AbstractTableModel;

import app.bsodsoftware.gameclub.java.entidades.usuarios.Usuario;

/**
 * Un modelo para las tablas.
 * 
 * @author Daniel Serrano Torres
 * @author Alvaro Quesada Pimentel
 * @author Juan Prérez Valbuena
 * @author Emilio Alvarez
 */
public class ModeloUsuarios extends AbstractTableModel implements MiModelo<Usuario> {

	private static final long serialVersionUID = -6900850597743594873L;

	private int numColum;
	private int numFilas;
	private Usuario[] usuarios;

	/**
	 * Columnas predefinidas del modelo para los juegos.
	 */
	private String[] columnas = { "DNI", "Nombre", "Apellidos", "Telefono", "Dirección", "Fecha de Nacimiento" };

	public ModeloUsuarios() {
		init(new Usuario[] {});
	}

	/**
	 * Crea un contenedor de usuarios para una tabla.
	 * 
	 * @param usuariosNuevos
	 *            Nueva lista de juegos
	 * @param columnas
	 *            Nombres de las columnas.
	 */
	public ModeloUsuarios(Usuario[] usuariosNuevos) {
		init(usuariosNuevos);
	}

	private void init(Usuario[] usuariosNuevos) {
		numColum = columnas.length;
		numFilas = usuariosNuevos.length;
		usuarios = usuariosNuevos;
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

		if (usuarios.length > 0) {
			switch (column) {
			case 0:
				dato = usuarios[row].getDni();
				break;

			case 1:
				dato = usuarios[row].getNombre();
				break;

			case 2:
				dato = usuarios[row].getApellidos();
				break;
			case 3:
				dato = usuarios[row].getTelefono();
				break;

			case 4:
				dato = usuarios[row].getDireccion();
				break;

			case 5:
				dato = usuarios[row].getFecha_nacimiento();
				break;

			}
		}

		return dato;
	}

	/**
	 * Método que cambia los datos de la tabla.
	 * 
	 * @param usuariosNuevos
	 *            Nueva lista de datos.
	 */
	public void setObjetos(Usuario[] usuariosNuevos) {
		usuarios = usuariosNuevos;
		numFilas = usuarios.length;
	}

	/**
	 * Método que rellena los datos en la tabla.
	 */
	@Override
	public void rellenar() {

		for (int i = 0; i < usuarios.length; i++) {
			setValueAt(usuarios[i].getDni(), i, 0);
			setValueAt(usuarios[i].getNombre(), i, 1);
			setValueAt(usuarios[i].getApellidos(), i, 2);
			setValueAt(usuarios[i].getTelefono(), i , 3);
			setValueAt(usuarios[i].getDireccion(), i , 4);
			setValueAt(usuarios[i].getFecha_nacimiento(), i , 5);
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
	 * 
	 * @param fila
	 *            Fila de la tabla que tenga el modelo.
	 * @return El juego.
	 */
	public Usuario getUsuario(int fila) {

		Usuario usuario = null;

		if (fila <= usuarios.length) {
			usuario = usuarios[fila];
		}

		return usuario;
	}

	@Override
	public String[] getColumnas() {

		return columnas;
	}

	@Override
	public void modificar(int indice, Usuario usuarioModificado) {

		usuarios[indice] = usuarioModificado;
		fireTableDataChanged();
	}

	@Override
	public int buscar(Usuario elementoaBuscar) {
		int indice = -1;
		
		for (int i = 0; i < usuarios.length; i++) {
			if (usuarios[i].equals(elementoaBuscar)) {
				indice = i;
			}
		}
		
		return indice;
	}
}
