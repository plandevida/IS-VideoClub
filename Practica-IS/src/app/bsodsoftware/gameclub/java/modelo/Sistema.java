package app.bsodsoftware.gameclub.java.modelo;

import java.util.ArrayList;
import java.util.List;

import app.bsodsoftware.gameclub.java.entidades.juego.Juego;
import app.bsodsoftware.gameclub.java.entidades.prestar.Prestamo;
import app.bsodsoftware.gameclub.java.entidades.usuarios.Usuario;
import app.bsodsoftware.gameclub.java.modelo.fachadas.InterfazFachadaUsuario;


public class Sistema  {
/*
	private ArrayList<Usuario> listaUsuarios;

	private ArrayList<Juego> listaJuegos;

	private ArrayList<Prestamo> listaPrestamos;
	*/
	SistemaUsuarios sistemaUsuarios;
	SistemaJuegos sistemaJuegos ;
	SistemaPrestamos sistemaPrestamos;
	
	public Sistema()
	{
		
		//sistemaUsuarios = new SistemaUsuarios();
		
		
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