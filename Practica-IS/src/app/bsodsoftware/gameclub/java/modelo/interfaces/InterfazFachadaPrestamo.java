package app.bsodsoftware.gameclub.java.modelo.interfaces;

import app.bsodsoftware.gameclub.java.entidades.prestar.Prestamo;

/**
 * Interfaz para el acceso a los prestamos del modelo
 * 
 * @author Daniel Serrano Torres
 * @author Juan Luis Perez Valbuena
 * @author Alvaro Quesada Pimentel
 * @author Emilio Alvarez Viñeiro
 */
public interface InterfazFachadaPrestamo {

	/**
	 * Añade un prestamo a la bbdd
	 * 
	 * @param prestamo
	 *            Prestamo a añadir
	 * @return Si se añadio correctamente
	 */
	public boolean addPrestamo(Prestamo prestamo);

	/**
	 * Modifica los datos de un prestamo en la bbdd.
	 * 
	 * @param prestamo
	 *            Prestamo con los datos modificados.
	 * @return Si se modifico correctamente
	 */
	public boolean modificarPrestamo(Prestamo prestamo);

	/**
	 * Borra un prestamo de la bbdd.
	 * 
	 * @param idUsuario
	 *            Id del prestamo.
	 * @return True si lo ha borrado, false EOC.
	 */
	public boolean borrarPrestamo(Prestamo prestamo);

	/**
	 * Comprueba si el prestamo ya está en la bbdd.
	 * 
	 * @param idPrestamo
	 *            Id del prestamo.
	 * @return True si exite, false EOC.
	 */
	public boolean existePrestamo(Prestamo prestamo);
	
	/**
	 * Obtiene todos los préstamos.
	 * 
	 * @return Lista de préstamos almacenados.
	 */
	public Prestamo[] consultarPrestamos();
}
