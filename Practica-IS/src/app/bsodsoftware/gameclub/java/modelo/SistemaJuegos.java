package app.bsodsoftware.gameclub.java.modelo;

import java.util.ArrayList;

import app.bsodsoftware.gameclub.java.entidades.juego.Juego;
import app.bsodsoftware.gameclub.java.entrada.Lectura;
import app.bsodsoftware.gameclub.java.modelo.fachadas.InterfazFachadaJuego;

public class SistemaJuegos implements InterfazFachadaJuego {

	ArrayList<Juego> listaJuegos = new ArrayList<Juego>();

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
				// addjuego(new Juego());

			}
		} catch (Exception e) {

		} finally {

		}

	}

	@Override
	public void escribirFichero() {
		// TODO Auto-generated method stub

	}

}
