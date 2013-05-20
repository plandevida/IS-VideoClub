package app.bsodsoftware.gameclub.java.modelo.fachadas;

public interface InterfazFicheros {

	/**
	 * Carga todos los datos necesarios de un fichero de texto
	 */
	public void cargarFichero();

	/**
	 * Vuelca toda la informacion de las listas a su correspondiente fichero de
	 * texto.
	 */
	public void escribirFichero();

}
