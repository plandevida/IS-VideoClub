package app.bsodsoftware.gameclub.java.modelo;

import java.util.ArrayList;

import app.bsodsoftware.gameclub.java.entidades.usuarios.Usuario;
import app.bsodsoftware.gameclub.java.modelo.fachadas.InterfazFachadaUsuario;

public class SistemaUsuarios implements InterfazFachadaUsuario {

	
	private ArrayList<Usuario> listaUsuarios;

	
	public SistemaUsuarios()
	{

		listaUsuarios.add(new Usuario("12345678A", "Juan", "Trama"));
		//listaUsuarios=cargarfichero();
	}
	@Override
	public Usuario addUsuario(Usuario usuario) {
	
		//Añadir el usuario a la lista
		//Persistencia en fichero
		
		return null;// true false
	}
	

	@Override
	public Usuario modificarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean borrarUsuario(Integer idUsuario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existeUsuario(Integer idUsuario) {
		// TODO Auto-generated method stub
		return false;
	}

}
