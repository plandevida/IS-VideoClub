package app.bsodsoftware.gameclub.java.entidades.usuarios;

import java.util.Date;

public class Usuario {

	private String dni;

	private String nombre;

	private String apellidos;

	private boolean sancionado;

	private Date hasta;

	private Date fecha_nacimiento;

	private String direccion;

	private int telefono;

	public Usuario(String dni, String nombre, String apellidos,
			Date fecha_nacimiento, String direccion, int telefono) {

		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fecha_nacimiento = fecha_nacimiento;
		this.direccion = direccion;
		this.telefono = telefono;
		this.hasta = null;
		this.sancionado = false;
		
	}

	public String getDni() {
		return dni;
	}

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

	public boolean isSancionado() {
		return sancionado;
	}

	public void setSancionado(boolean sancionado) {
		this.sancionado = sancionado;
	}

	public Date getHasta() {
		return hasta;
	}

	public void setHasta(Date hasta) {
		this.hasta = hasta;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	@Override
	public boolean equals(Object o) {
		
		boolean igual = false;
		
		if ( o instanceof Usuario ) {
			
			Usuario u = (Usuario) o;
			
			if ( this.getDni().equals(u.getDni()) ) {
				igual = true;
			}
		}
		
		return igual;
	}
}