package app.bsodsoftware.gameclub.java.entidades.usuarios;

import java.util.Date;

public class Usuario {

	private String dni;

	private String nombre;

	private String apellidos;

	private boolean sancionado;

	private Date hasta;

	public Usuario(String nuevo_dni, String nuevo_nombre, String nuevo_apellidos) {

		setDni(nuevo_dni);
		setNombre(nuevo_nombre);
		setApellidos(nuevo_apellidos);
		sancionado = false;
		hasta = null;

	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni
	 *            the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

}