package app.bsodsoftware.gameclub.java.modelo;

import java.util.ArrayList;

import app.bsodsoftware.gameclub.java.entidades.usuarios.Usuario;
import app.bsodsoftware.gameclub.java.entrada.Escritura;
import app.bsodsoftware.gameclub.java.entrada.Lectura;
import app.bsodsoftware.gameclub.java.modelo.fachadas.InterfazFachadaUsuario;

public class SistemaUsuarios implements InterfazFachadaUsuario {

	private ArrayList<Usuario> listaUsuarios;

	public SistemaUsuarios() {

		listaUsuarios = new ArrayList<Usuario>();
		// listaUsuarios = new ArrayList<Usuario>();
		listaUsuarios.add(new Usuario("12345678A", "Juan", "Trama", null,
				"calle", 6541942));

		cargarFichero();
		escribirFichero();

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
		boolean resultado = true;
		if (!existeUsuario(usuario)) {
			resultado = false;

		} else {

		}
		return resultado;
	}

	@Override
	public boolean borrarUsuario(Usuario usuario) {

		boolean resultado = true;
		if (!existeUsuario(usuario)) {
			resultado = false;
		} else {
			listaUsuarios.remove(usuario);
			resultado = true;
		}
		return resultado;

	}

	@Override
	public boolean existeUsuario(Usuario usuario) {

		return listaUsuarios.contains(usuario);
	}

	@Override
	public void cargarFichero() {

		Lectura entrada_de_datos_por_fichero = new Lectura("usuarios.txt");
		String linea_usuario;

		try {
			while ((linea_usuario = entrada_de_datos_por_fichero.leerLinea()) != null) {

				String datos[] = linea_usuario.split(":");
				addUsuario(new Usuario(datos[0], datos[1], datos[2], null,
						null, 0));

			}
		} catch (Exception e) {

		} finally {

		}

	}

	@Override
	public void escribirFichero() {
		Escritura salida_de_datos_por_fichero = new Escritura("usuarios.txt");
		String linea_usuario;

		for (Usuario u : listaUsuarios) {

			linea_usuario = "";
			linea_usuario += u.getDni() + ":" + u.getNombre() + ":"
					+ u.getApellidos() + "\n";
			System.out.println(linea_usuario);

			salida_de_datos_por_fichero.escribirLinea(linea_usuario);
		}

	}

}
