package app.bsodsoftware.gameclub.java.modelo.implementacion;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import app.bsodsoftware.gameclub.java.entidades.usuarios.Usuario;
import app.bsodsoftware.gameclub.java.entrada.Escritura;
import app.bsodsoftware.gameclub.java.entrada.Lectura;
import app.bsodsoftware.gameclub.java.modelo.interfaces.InterfazFachadaUsuario;
import app.bsodsoftware.gameclub.java.modelo.interfaces.InterfazFicheros;

public class SistemaUsuarios implements InterfazFachadaUsuario,
		InterfazFicheros {

	private ArrayList<Usuario> listaUsuarios;

	public SistemaUsuarios() {

		listaUsuarios = new ArrayList<Usuario>();

	}

	@Override
	public boolean addUsuario(Usuario usuario) {

		boolean resultado = false;

		if (!existeUsuario(usuario) && buscaUsuario(usuario.getDni()) == null) {

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
			int indice = listaUsuarios.indexOf(usuario);

			listaUsuarios.remove(indice);

			listaUsuarios.add(indice, usuario);
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
			while (!"EOF"
					.equalsIgnoreCase(linea_usuario = entrada_de_datos_por_fichero
							.leerLinea())) {

				if (!"".equals(linea_usuario)) {

					String datos[] = linea_usuario.split(":");
					addUsuario(new Usuario(datos[0], datos[1], datos[2],
							new SimpleDateFormat("dd-MM-YYYY").parse(datos[3]),
							datos[4], Integer.parseInt(datos[5])));
				}

			}
		} catch (Exception e) {

		} finally {
			entrada_de_datos_por_fichero.cerrarFichero();
		}
	}

	@Override
	public void escribirFichero() {
		Escritura salida_de_datos_por_fichero = new Escritura("usuarios.txt");
		String linea_usuario;

		for (Usuario u : listaUsuarios) {

			/*
			 * public Usuario(String dni, String nombre, String apellidos, Date
			 * fecha_nacimiento, String direccion, int telefono) {
			 */
			linea_usuario = "";
			linea_usuario += u.getDni()
					+ ":"
					+ u.getNombre()
					+ ":"
					+ u.getApellidos()
					+ ":"
					+ new SimpleDateFormat("dd-MM-YYYY").format(u
							.getFecha_nacimiento()) + ":" + u.getDireccion()
					+ ":" + u.getTelefono() + "\n";

			salida_de_datos_por_fichero.escribirLinea(linea_usuario);
		}

		salida_de_datos_por_fichero.escribirLinea("EOF");

		salida_de_datos_por_fichero.cerrarFichero();
	}

	@Override
	public Usuario buscaUsuario(String DNI) {
		Usuario usuario_a_devolver = null;
		for (Usuario usuario_de_la_lista : listaUsuarios) {
			if (usuario_de_la_lista.getDni().equalsIgnoreCase(DNI))
				usuario_a_devolver = usuario_de_la_lista;
		}

		return usuario_a_devolver;

	}

	@Override
	public Usuario[] consultarUsuarios() {

		return listaUsuarios.toArray(new Usuario[listaUsuarios.size()]);
	}

}