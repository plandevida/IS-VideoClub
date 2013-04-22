package com.bsodsoftware.gameclub.java.entidades.juego;

public class Juego {

	String nombre;

	private int idjuego;

	private String comentarios;

	private int num_copias;

	private int num_copias_prestadas;

	public Juego(int nuevo_id, String nuevo_nombre, String nuevo_comentarios,int nuevo_num_copias) {
		
		idjuego=nuevo_id;
		comentarios=nuevo_comentarios;
		num_copias=nuevo_num_copias;
		num_copias_prestadas=0;
	}
}