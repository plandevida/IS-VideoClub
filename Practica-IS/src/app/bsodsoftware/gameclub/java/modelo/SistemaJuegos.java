package app.bsodsoftware.gameclub.java.modelo;

import java.util.ArrayList;

import app.bsodsoftware.gameclub.java.entidades.juego.Juego;
import app.bsodsoftware.gameclub.java.modelo.fachadas.InterfazFachadaJuego;

public class SistemaJuegos implements InterfazFachadaJuego {

	ArrayList<Juego> listaJuegos = new ArrayList<Juego>();
	
	@Override
	public Juego addjuego(Juego juego) {
		
		listaJuegos.add(new Juego(0, "Colonos del Catan", "Muy Interesante", 5));
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Juego modificarjuego(Juego juego) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean borrarjuego(Integer idJuego) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existejuego(Integer idJuego) {
		// TODO Auto-generated method stub
		return false;
	}

}