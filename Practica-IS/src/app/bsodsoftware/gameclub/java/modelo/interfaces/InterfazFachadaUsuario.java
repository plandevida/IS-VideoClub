package app.bsodsoftware.gameclub.java.modelo.interfaces;

import app.bsodsoftware.gameclub.java.entidades.usuarios.Usuario;

/**
 * Interfaz para el acceso a los usuarios del modelo
 * 
 * @author Daniel Serrano Torres
 * @author Juan Luis Perez Valbuena
 * @author Alvaro Quesada Pimentel
 * @author Emilio Alvarez Viñeiro
 */
public interface InterfazFachadaUsuario {

	/**
	 * Añade un usuario a la bbdd
	 * 
	 * @param usuario
	 *            Usuario a añadir
	 * @return El nuevo usuario (con el id de la bbdd).
	 */
	public boolean addUsuario(Usuario usuario);

	/**
	 * Modifica los datos de un usuario en la bbdd.
	 * 
	 * @param usuario
	 *            Usuario con los datos modificados.
	 * @return El usuario modificado si se ha podido guardar.
	 */
	public boolean modificarUsuario(Usuario usuario);

	/**
	 * Borra un usuario de la bbdd.
	 * 
	 * @param idUsuario
	 *            Id de usuario.
	 * @return True si lo ha borrado, false EOC.
	 */
	public boolean borrarUsuario(Usuario usuario);

	/**
	 * Comprueba si el usuario ya está en la bbdd.
	 * 
	 * @param idUsuario
	 *            Id de usuario.
	 * @return True si exite, false EOC.
	 */
	public boolean existeUsuario(Usuario usuario);

	/**
	 * Busca un usuario por su DNI
	 * 
	 * @param DNI
	 *            Del usuario a buscar. io a buscar.
	 * @return El usuario buscado o null si no se encontró;
	 */
	public Usuario buscaUsuario(String DNI);

	public Usuario[] consultarUsuarios();
}
