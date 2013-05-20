package app.bsodsoftware.gameclub.java.modelo;

import java.util.ArrayList;

import app.bsodsoftware.gameclub.java.entidades.usuarios.Usuario;
import app.bsodsoftware.gameclub.java.modelo.fachadas.InterfazFachadaUsuario;

import app.bsodsoftware.gameclub.java.entrada.*;

public class SistemaUsuarios implements InterfazFachadaUsuario {

	private ArrayList<Usuario> listaUsuarios;

	public SistemaUsuarios() {

		// listaUsuarios = new ArrayList<Usuario>();
		listaUsuarios.add(new Usuario("12345678A", "Juan", "Trama",null,"calle", 6541942));
		cargarFichero();

	}

	@Override
	public boolean addUsuario(Usuario usuario) {

		boolean resultado = false;

		if (!existeUsuario(usuario)) {

			listaUsuarios.add(usuario);
			resultado = true;
		}
		return resultado;
	}

	@Override
	public boolean modificarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean borrarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existeUsuario(Usuario usuario) {

		boolean resultado = false;
		if (listaUsuarios.contains(usuario)) {

			resultado = true;
		}

		System.out.println("resultado " + resultado);
		return resultado;
	}

	@Override
	public void cargarFichero() {

		Lectura entrada_de_datos_por_fichero = new Lectura("usuarios.txt");
		String linea_usuario;

		try {
			while ((linea_usuario = entrada_de_datos_por_fichero.leerLinea()) != null) {

				String datos[] = linea_usuario.split(":");
				System.out.println(datos[0]);
				System.out.println(datos[1]);
				System.out.println(datos[2]);
				addUsuario(new Usuario(datos[0], datos[1], datos[2]));

			}
		} catch (Exception e) {

		} finally {

		}

	}

}
