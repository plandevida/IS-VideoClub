package app.bsodsoftware.gameclub.java.entidades.usuarios;

import java.util.Date;

public class Usuario {

	private String dni;

	private String nombre;

	private String apellidos;

	private boolean sancionado;

	private Date hasta;

	public Usuario(String nuevo_dni, String nuevo_nombre, String nuevo_apellidos) {
		
		dni=nuevo_dni;
		nombre=nuevo_nombre;
		apellidos=nuevo_apellidos;
		sancionado=false;
		hasta=null;
		
		
	}

	
}