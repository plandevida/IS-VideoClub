package app.bsodsoftware.gameclub.java.modelo.controlador;

import java.util.ArrayList;
import java.util.List;

import app.bsodsoftware.gameclub.java.entidades.juego.Juego;
import app.bsodsoftware.gameclub.java.entidades.prestar.Prestamo;
import app.bsodsoftware.gameclub.java.entidades.usuarios.Usuario;


public class Sistema {

	public ArrayList<Usuario> listaUsuarios;

	public ArrayList<Juego> listaJuegos;

	public ArrayList<Prestamo> listaPrestamos;

	
	public Sistema(ArrayList<Usuario> lista_usuarios, ArrayList<Juego> lista_juegos, ArrayList<Prestamo> lista_prestamos)
	{
		listaUsuarios=lista_usuarios;
		listaJuegos=lista_juegos;
		listaPrestamos=lista_prestamos;
		
		
	}
	
	public void Prestar(int idjuego, int idcopia, boolean disponible) {

	}

	public void Devolver() {
	}

	public void DarDeAltaUsuario() {
	}

	public void ConsultarTodosPrestamos() {
	}

	public void DarDeAltaJuego() {
	}

	public void ConsultarPrestamo() {
	}

	public void DevolverPrestamo() {
	}
}