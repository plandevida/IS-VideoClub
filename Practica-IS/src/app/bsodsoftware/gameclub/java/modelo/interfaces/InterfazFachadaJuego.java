package app.bsodsoftware.gameclub.java.modelo.interfaces;

import app.bsodsoftware.gameclub.java.entidades.juego.Juego;

/**
 * Interfaz para el acceso a los juegos del modelo
 * 
 * @author Daniel Serrano Torres
 * @author Juan Luis Perez Valbuena
 * @author Alvaro Quesada Pimentel
 * @author Emilio Alvarez Viñeiro
 */
public interface InterfazFachadaJuego {

	/**
	 * Añade un juego a la bbdd
	 * 
	 * @param juego Juego a añadir
	 * @return El nuevo juego (con el id de la bbdd).
	 */
	public boolean addjuego(Juego juego);

	/**
	 * Modifica los datos de un juego en la bbdd.
	 * 
	 * @param juego juego con los datos modificados.
	 * @return El juego modificado si se ha podido guardar.
	 */
	public boolean modificarjuego(Juego juego);

	/**
	 * Borra un juego de la bbdd.
	 * 
	 * @param idJuego Id de juego.
	 * @return True si lo ha borrado, false EOC.
	 */
	public boolean borrarjuego(Juego juego);

	/**
	 * Comprueba si el juego ya está en la bbdd.
	 * 
	 * @param idJuego
	 *            Id de juego.
	 * @return True si exite, false EOC.
	 */
	public boolean existejuego(Juego juego);

	/**
	 * Obtiene un juego a partir de su nombre.
	 * 
	 * @param nombre El nombre del juego
	 * @return El juego buscado o null si no se encontró.
	 */
	public Juego buscaJuego(String nombre);
	
	/**
	 * Obtiene todos los juegos almacenados.
	 * 
	 * @return Lista de juegos almancenados.
	 */
	public Juego[] consultarJuegos();
}
