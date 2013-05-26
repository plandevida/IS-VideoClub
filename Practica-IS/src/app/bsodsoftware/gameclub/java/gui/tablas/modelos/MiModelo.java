package app.bsodsoftware.gameclub.java.gui.tablas.modelos;

public interface MiModelo {

	/**
	 * Obtiene las columnas del modelo
	 * @return Columnas del modelo.
	 */
	public String[] getColumnas();
	
	/**
	 * Vuelca los datos del modelo en la tabla.
	 * Usarlo después de cambiar los datos.
	 */
	public void rellenar();
}
