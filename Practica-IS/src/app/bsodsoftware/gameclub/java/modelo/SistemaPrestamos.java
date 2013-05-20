package app.bsodsoftware.gameclub.java.modelo;

import java.util.ArrayList;

import app.bsodsoftware.gameclub.java.entidades.prestar.Prestamo;
import app.bsodsoftware.gameclub.java.modelo.fachadas.InterfazFachadaPrestamo;

public class SistemaPrestamos implements InterfazFachadaPrestamo {

	ArrayList<Prestamo> listaPrestamos = new ArrayList<Prestamo>();

	@Override
	public boolean addPrestamo(Prestamo prestamo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificarPrestamo(Prestamo prestamo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean borrarPrestamo(Integer idPrestamo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existePrestamo(Integer idPrestamo) {
		// TODO Auto-generated method stub
		return false;
	}

}
