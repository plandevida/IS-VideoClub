package app.bsodsoftware.gameclub.java.modelo.implementacion;

import java.util.ArrayList;

import app.bsodsoftware.gameclub.java.entidades.juego.Juego;
import app.bsodsoftware.gameclub.java.entrada.Escritura;
import app.bsodsoftware.gameclub.java.entrada.Lectura;
import app.bsodsoftware.gameclub.java.modelo.interfaces.InterfazFachadaJuego;
import app.bsodsoftware.gameclub.java.modelo.interfaces.InterfazFicheros;

public class SistemaJuegos implements InterfazFachadaJuego, InterfazFicheros {

	private ArrayList<Juego> listaJuegos;

	public SistemaJuegos() {
		listaJuegos = new ArrayList<Juego>();
//		listaJuegos.add(new Juego("Catan the game", 4, 3, 18,
//				"altamente destructivo", null));
//		cargarFichero();
	}

	@Override
	public boolean addjuego(Juego juego) {

		boolean resultado = false;

		if (!existejuego(juego)) {

			listaJuegos.add(juego);
			resultado = true;
		}
		return resultado;
	}

	@Override
	public boolean modificarjuego(Juego juego) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean borrarjuego(Juego juego) {
		boolean resultado = true;
		if (!existejuego(juego)) {
			resultado = false;
		} else {
			listaJuegos.remove(juego);
			resultado = true;
		}
		return resultado;
	}

	@Override
	public boolean existejuego(Juego juego) {
		return listaJuegos.contains(juego);
	}

	@Override
	public void cargarFichero() {
		Lectura entrada_de_datos_por_fichero = new Lectura("juegos.txt");
		String linea_juego;

		try {
			while ((linea_juego = entrada_de_datos_por_fichero.leerLinea()) != null) {

				String datos[] = linea_juego.split(":");
				addjuego(new Juego(datos[0], Integer.parseInt(datos[1]),
						Integer.parseInt(datos[2]), Integer.parseInt(datos[3]),
						datos[4], null));

			}
		} catch (Exception e) {

		} finally {
			entrada_de_datos_por_fichero.cerrarFichero();
		}
	}

	@Override
	public void escribirFichero() {
		Escritura salida_de_datos_por_fichero = new Escritura("juegos.txt");
		String linea_juego;

		for (Juego j : listaJuegos) {

			linea_juego = "";
			linea_juego += j.getNombre() + ":" + j.getNum_jugadores() + ":"
					+ j.getUnidades() + ":" + j.getEdad_minima() + ":"
					+ j.getDescripcion() + "\n";
			// System.out.println("linea->" + linea_juego);
			salida_de_datos_por_fichero.escribirLinea(linea_juego);
		}
		
		salida_de_datos_por_fichero.cerrarFichero();
	}

	@Override
	public Juego buscaJuego(String nombre) {
		Juego juego_a_devolver = null;
		for (Juego juego_de_la_lista : listaJuegos) {
			if (juego_de_la_lista.getNombre().equalsIgnoreCase(nombre))
				juego_a_devolver = juego_de_la_lista;
		}

		return juego_a_devolver;
	}

	@Override
	public Juego[] consultarJuegos() {
		
		return listaJuegos.toArray(new Juego[listaJuegos.size()]);
	}
}
