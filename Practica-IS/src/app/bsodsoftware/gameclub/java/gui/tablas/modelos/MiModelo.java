package app.bsodsoftware.gameclub.java.gui.tablas.modelos;


public interface MiModelo<E> {

	/**
	 * Obtiene las columnas del modelo
	 * 
	 * @return Columnas del modelo.
	 */
	public String[] getColumnas();

	/**
	 * Vuelca los datos del modelo en la tabla. Usarlo después de cambiar los
	 * datos.
	 */
	public void rellenar();
	
	/**
	 * Modifica un elemento de la tabla.
	 * El indice conincide con la fila.
	 */
	public void modificar(int indice, E elementoModificado);
	
	/**
	 * Busca un elemento, si está devuelve su indice, sino -1.
	 * @param elementoaBuscar
	 * @return indice
	 */
	public int buscar(E elementoaBuscar);
}
