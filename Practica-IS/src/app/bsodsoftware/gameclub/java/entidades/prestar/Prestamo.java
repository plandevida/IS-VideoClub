package app.bsodsoftware.gameclub.java.entidades.prestar;

import java.util.Date;

import app.bsodsoftware.gameclub.java.entidades.juego.Juego;
import app.bsodsoftware.gameclub.java.entidades.usuarios.Usuario;

public class Prestamo {

  private Usuario usuario_a_prestar;

  private Juego juego_a_prestar;

  private Date fecha_de_prestamos;

  private Date fecha_a_devolver;

  public Prestamo(Usuario usuario_a_prestar, Juego juego_a_prestar, Date fecha_de_prestamos, Date fecha_a_devolver) {
	  
	  this.usuario_a_prestar = usuario_a_prestar;
	  this.juego_a_prestar = juego_a_prestar;
	  this.fecha_de_prestamos = fecha_de_prestamos;
	  this.fecha_a_devolver = fecha_de_prestamos;
  }

public Usuario getUsuario_a_prestar() {
	return usuario_a_prestar;
}

public void setUsuario_a_prestar(Usuario usuario_a_prestar) {
	this.usuario_a_prestar = usuario_a_prestar;
}

public Juego getJuego_a_prestar() {
	return juego_a_prestar;
}

public void setJuego_a_prestar(Juego juego_a_prestar) {
	this.juego_a_prestar = juego_a_prestar;
}

public Date getFecha_de_prestamos() {
	return fecha_de_prestamos;
}

public void setFecha_de_prestamos(Date fecha_de_prestamos) {
	this.fecha_de_prestamos = fecha_de_prestamos;
}

public Date getFecha_a_devolver() {
	return fecha_a_devolver;
}

public void setFecha_a_devolver(Date fecha_a_devolver) {
	this.fecha_a_devolver = fecha_a_devolver;
}
}