package app.bsodsoftware.gameclub.java.modelo.fachadas;

import app.bsodsoftware.gameclub.java.entidades.usuarios.Usuario;

/**
 * Interfaz para el acceso a los usuarios del modelo
 * 
 * @author Daniel Serrano Torres
 * @author Juan Luis Perez Valbuena
 * @author Alvaro Quesada Pimentel
 * @author Emilio Alvarez Viñeiro
 */
public interface IntefazFachadaUsuario {
	
	/**
	 * Añade un usuario a la bbdd
	 * 
	 * @param usuario Usuario a añadir
	 * @return El nuevo usuario (con el id de la bbdd).
	 */
	public Usuario addUsuario(Usuario usuario);
	
	/**
	 * Modifica los datos de un usuario en la bbdd.
	 * 
	 * @param usuario Usuario con los datos modificados.
	 * @return El usuario modificado si se ha podido guardar.
	 */
	public Usuario modificarUsuario(Usuario usuario);
	
	/**
	 * Borra un usuario de la bbdd.
	 * 
	 * @param idUsuario Id de usuario.
	 * @return True si lo ha borrado, false EOC.
	 */
	public boolean borrarUsuario(Integer idUsuario);
	
	/**
	 * Comprueba si el usuario ya está en la bbdd.
	 * 
	 * @param idUsuario Id de usuario.
	 * @return True si exite, false EOC.
	 */
	public boolean existeUsuario(Integer idUsuario);
}
