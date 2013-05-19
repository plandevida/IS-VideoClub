package app.bsodsoftware.gameclub.java.entidades.juego;

import javax.swing.ImageIcon;

public class Juego {

	String nombre;

	private int idjuego;

	private String comentarios;

	private int num_copias;

	private int num_copias_prestadas;
	
	private ImageIcon imagen;
	
	private int numero_jugadores;

	public Juego(int nuevo_id, String nuevo_nombre, int nuevo_numero_juegadores, String nuevo_comentarios,
			int nuevo_num_copias, ImageIcon imagenCaja) {

		idjuego = nuevo_id;
		nombre = nuevo_nombre;
		numero_jugadores = nuevo_numero_juegadores;
		comentarios = nuevo_comentarios;
		num_copias = nuevo_num_copias;
		num_copias_prestadas = 0;
		imagen = imagenCaja;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getIdjuego() {
		return idjuego;
	}

	public void setIdjuego(int idjuego) {
		this.idjuego = idjuego;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public int getNum_copias() {
		return num_copias;
	}

	public void setNum_copias(int num_copias) {
		this.num_copias = num_copias;
	}

	public int getNum_copias_prestadas() {
		return num_copias_prestadas;
	}

	public void setNum_copias_prestadas(int num_copias_prestadas) {
		this.num_copias_prestadas = num_copias_prestadas;
	}

	public ImageIcon getImagen() {
		return imagen;
	}

	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}

	public int getNumero_jugadores() {
		return numero_jugadores;
	}

	public void setNumero_jugadores(int numero_jugadores) {
		this.numero_jugadores = numero_jugadores;
	}
}
