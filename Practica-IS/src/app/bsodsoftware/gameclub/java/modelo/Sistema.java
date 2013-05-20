package app.bsodsoftware.gameclub.java.modelo;

import app.bsodsoftware.gameclub.java.entidades.juego.Juego;
import app.bsodsoftware.gameclub.java.entidades.prestar.Prestamo;
import app.bsodsoftware.gameclub.java.entidades.usuarios.Usuario;
import app.bsodsoftware.gameclub.java.modelo.fachadas.InterfazFachadaJuego;
import app.bsodsoftware.gameclub.java.modelo.fachadas.InterfazFachadaPrestamo;
import app.bsodsoftware.gameclub.java.modelo.fachadas.InterfazFachadaUsuario;
import app.bsodsoftware.gameclub.java.modelo.fachadas.InterfazFicheros;

public class Sistema implements InterfazFicheros, InterfazFachadaJuego,
		InterfazFachadaPrestamo, InterfazFachadaUsuario {

	private SistemaUsuarios sistemaUsuarios;
	private SistemaJuegos sistemaJuegos;
	private SistemaPrestamos sistemaPrestamos;

	public Sistema() {
		sistemaUsuarios = new SistemaUsuarios();
		sistemaJuegos = new SistemaJuegos();
		sistemaPrestamos = new SistemaPrestamos(sistemaUsuarios, sistemaJuegos);

	}

	@Override
	public boolean addUsuario(Usuario usuario) {
		return sistemaUsuarios.addUsuario(usuario);
	}

	@Override
	public boolean modificarUsuario(Usuario usuario) {
		return sistemaUsuarios.modificarUsuario(usuario);
	}

	@Override
	public boolean borrarUsuario(Usuario usuario) {
		return sistemaUsuarios.borrarUsuario(usuario);
	}

	@Override
	public boolean existeUsuario(Usuario usuario) {
		return sistemaUsuarios.existeUsuario(usuario);
	}

	@Override
	public Usuario buscaUsuario(String DNI) {
		return sistemaUsuarios.buscaUsuario(DNI);
	}

	@Override
	public boolean addPrestamo(Prestamo prestamo) {
		return sistemaPrestamos.addPrestamo(prestamo);
	}

	@Override
	public boolean modificarPrestamo(Prestamo prestamo) {
		return sistemaPrestamos.modificarPrestamo(prestamo);
	}

	@Override
	public boolean borrarPrestamo(Prestamo prestamo) {
		return sistemaPrestamos.borrarPrestamo(prestamo);
	}

	@Override
	public boolean existePrestamo(Prestamo prestamo) {
		return sistemaPrestamos.existePrestamo(prestamo);
	}

	@Override
	public boolean addjuego(Juego juego) {
		return sistemaJuegos.addjuego(juego);
	}

	@Override
	public boolean modificarjuego(Juego juego) {
		return sistemaJuegos.modificarjuego(juego);
	}

	@Override
	public boolean borrarjuego(Juego juego) {
		return sistemaJuegos.borrarjuego(juego);
	}

	@Override
	public boolean existejuego(Juego juego) {
		return sistemaJuegos.existejuego(juego);
	}

	@Override
	public Juego buscaJuego(String nombre) {
		return sistemaJuegos.buscaJuego(nombre);
	}

	@Override
	public void cargarFichero() {
		
	

	}

	@Override
	public void escribirFichero() {
		
		sistemaJuegos.escribirFichero();
		sistemaPrestamos.escribirFichero();
		sistemaUsuarios.escribirFichero();

	}

}