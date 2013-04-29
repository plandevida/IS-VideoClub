package app.bsodsoftware.gameclub.java.entidades.prestar;

import java.util.Date;

import app.bsodsoftware.gameclub.java.entidades.juego.Juego;
import app.bsodsoftware.gameclub.java.entidades.usuarios.Usuario;


public class Prestamo {

	public Usuario usuario_a_prestar;

	public Juego juego_a_prestar;

	public Date fecha_de_prestamos;

	public int fecha_a_devolver;

	public Prestamo (Usuario usuario_a_prestar,
			Prestamo juego_a_prestar, Date fecha_actual) {
		
	}
}