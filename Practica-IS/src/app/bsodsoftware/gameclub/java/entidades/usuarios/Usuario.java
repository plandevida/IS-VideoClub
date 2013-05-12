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
		nombre = nuevo_nombre;
		apellidos = nuevo_apellidos;
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

}