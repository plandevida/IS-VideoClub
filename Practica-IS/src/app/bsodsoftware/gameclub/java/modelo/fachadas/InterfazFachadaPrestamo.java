package app.bsodsoftware.gameclub.java.modelo.fachadas;

import app.bsodsoftware.gameclub.java.entidades.prestar.Prestamo;
import app.bsodsoftware.gameclub.java.entidades.usuarios.Usuario;


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
	 * @param prestamo Prestamo a añadir
	 * @return El nuevo prestamo (con el id de la bbdd).
	 */
	public Usuario addPrestamo(Prestamo prestamo);
	
	/**
	 * Modifica los datos de un prestamo en la bbdd.
	 * 
	 * @param prestamo Prestamo con los datos modificados.
	 * @return El prestamo modificado si se ha podido guardar.
	 */
	public Usuario modificarPrestamo(Prestamo prestamo);
	
	/**
	 * Borra un prestamo de la bbdd.
	 * 
	 * @param idUsuario Id del prestamo.
	 * @return True si lo ha borrado, false EOC.
	 */
	public boolean borrarPrestamo(Integer idPrestamo);
	
	/**
	 * Comprueba si el prestamo ya está en la bbdd.
	 * 
	 * @param idPrestamo Id del prestamo.
	 * @return True si exite, false EOC.
	 */
	public boolean existePrestamo(Integer idPrestamo);
}
