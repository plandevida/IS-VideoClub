package app.bsodsoftware.gameclub.java.entidades.juego;

import javax.swing.ImageIcon;

public class Juego {

	private int id;
	
	private String nombre;

	private int num_jugadores;

	private int unidades;

	private int unidades_prestadas;

	private int edad_minima;

	private String descripcion;

	private ImageIcon imagen;

	public Juego(int id, String nombre, int num_jugadores, int unidades,
			int edad_minima, String descipcion, ImageIcon imagen) {

		this.id = id;
		this.nombre = nombre;
		this.num_jugadores = num_jugadores;
		this.unidades = unidades;
		this.edad_minima = edad_minima;
		this.descripcion = descipcion;
		this.imagen = imagen;
		this.unidades_prestadas = 0;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNum_jugadores() {
		return num_jugadores;
	}

	public void setNum_jugadores(int num_jugadores) {
		this.num_jugadores = num_jugadores;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public int getUnidades_prestadas() {
		return unidades_prestadas;
	}

	public void setUnidades_prestadas(int unidades_prestadas) {
		this.unidades_prestadas = unidades_prestadas;
	}

	public int getEdad_minima() {
		return edad_minima;
	}

	public void setEdad_minima(int edad_minima) {
		this.edad_minima = edad_minima;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public ImageIcon getImagen() {
		return imagen;
	}

	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object o) {

		boolean igual = false;

		if (o instanceof Juego) {

			Juego j = (Juego) o;

			if (this.getId() == j.getId()) {
				igual = true;
			}
		}

		return igual;
	}
}
