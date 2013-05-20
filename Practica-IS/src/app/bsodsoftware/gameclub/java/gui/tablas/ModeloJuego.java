package app.bsodsoftware.gameclub.java.gui.tablas;

import javax.swing.table.DefaultTableModel;

import app.bsodsoftware.gameclub.java.entidades.juego.Juego;

public class ModeloJuego extends DefaultTableModel {

	private static final long serialVersionUID = -7174921828122713554L;

	public ModeloJuego(Juego[] data, String[] columns) {

		super(rellenar(data, columns.length), columns);
	}

	private static Object[][] rellenar(Juego[] juegos, int columnasLength) {

		Object[][] datos = new Object[juegos.length][columnasLength];

		for (int i = 0; i < juegos.length; i++) {
			datos[i][0] = juegos[i].getNombre();
			datos[i][1] = juegos[i].getImagen();
			datos[i][2] = juegos[i].getNumero_jugadores();
			datos[i][3] = juegos[i].getComentarios();
		}

		return datos;
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
