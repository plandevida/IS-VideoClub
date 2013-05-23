package app.bsodsoftware.gameclub.java.modelo.implementacion;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import app.bsodsoftware.gameclub.java.entidades.prestar.Prestamo;
import app.bsodsoftware.gameclub.java.entrada.Escritura;
import app.bsodsoftware.gameclub.java.entrada.Lectura;
import app.bsodsoftware.gameclub.java.modelo.interfaces.InterfazFachadaPrestamo;
import app.bsodsoftware.gameclub.java.modelo.interfaces.InterfazFicheros;

public class SistemaPrestamos implements InterfazFachadaPrestamo,
		InterfazFicheros {

	private ArrayList<Prestamo> listaPrestamos;
	private SistemaUsuarios sistema_usuarios;
	private SistemaJuegos sistema_juegos;

	public SistemaPrestamos(SistemaUsuarios _sistema_usuarios,
			SistemaJuegos _sistema_juegos) {

		listaPrestamos = new ArrayList<Prestamo>();
		sistema_juegos = _sistema_juegos;
		sistema_usuarios = _sistema_usuarios;

	/*	try {
			listaPrestamos.add(new Prestamo(sistema_usuarios
					.buscaUsuario("12345678A"), sistema_juegos
					.buscaJuego("Catan the game"),
					new SimpleDateFormat("dd-MM-yyyy").parse("20-01-2010"),
					new SimpleDateFormat("dd-MM-yyyy").parse("20-01-2010")));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
*/
		cargarFichero();
        escribirFichero();
	}

	@Override
	public boolean addPrestamo(Prestamo prestamo) {
		boolean resultado = false;

		if (!existePrestamo(prestamo)) {
			//comprueba que las unidades prestadas no superan a las unidades totales, y q el usuario no esta sancionado
			if((prestamo.getJuego_a_prestar().getUnidades_prestadas() < prestamo.getJuego_a_prestar().getUnidades()) && (!prestamo.getUsuario_a_prestar().isSancionado())) {
				
			
				listaPrestamos.add(prestamo);
				resultado = true;
			
				//aumenta las unidades prestadas del juego en 1
				prestamo.getJuego_a_prestar().setUnidades_prestadas((prestamo.getJuego_a_prestar().getUnidades_prestadas())+1);
			}
			
		}
		return resultado;
	}

	@Override
	public boolean modificarPrestamo(Prestamo prestamo) {
		boolean resultado = true;
		if (!existePrestamo(prestamo)) {
			resultado = false;

		} else {

		}
		return resultado;
	}

	@Override
	public boolean borrarPrestamo(Prestamo prestamo) {
		boolean resultado = true;
		if (!existePrestamo(prestamo)) {
			resultado = false;
		} else {
			
			//disminuye las unidades prestadas del juego en 1, comprueba que las unidades prestadas sean mayores de 0 para no pasar a numeros negativos
			if(prestamo.getJuego_a_prestar().getUnidades_prestadas()>0){
				prestamo.getJuego_a_prestar().setUnidades_prestadas((prestamo.getJuego_a_prestar().getUnidades_prestadas())-1);
			}
			
			listaPrestamos.remove(prestamo);
			resultado = true;
		}
		return resultado;
	}

	@Override
	public boolean existePrestamo(Prestamo prestamo) {
		return listaPrestamos.contains(prestamo);

	}

	@Override
	public void cargarFichero() {
		Lectura entrada_de_datos_por_fichero = new Lectura("prestamos.txt");
		String linea_prestamo;

		try {
			while ((linea_prestamo = entrada_de_datos_por_fichero.leerLinea()) != null) {

				String datos[] = linea_prestamo.split(":");
				// public Prestamo(Usuario usuario_a_prestar, Juego
				// juego_a_prestar,
				// Date fecha_de_prestamos, Date fecha_a_devolver) {

				addPrestamo(new Prestamo(
						sistema_usuarios.buscaUsuario(datos[0]),
						sistema_juegos.buscaJuego(datos[1]),
						new SimpleDateFormat("dd-MM-YYYY").parse(datos[2]),
						new SimpleDateFormat("dd-MM-YYYY").parse(datos[3])));
						
			}
		} catch (Exception e) {

		} finally {

		}

	}

	@Override
	public void escribirFichero() {
		Escritura salida_de_datos_por_fichero = new Escritura("prestamos.txt");
		String linea_prestamo;
	
		
		for (Prestamo p : listaPrestamos) {
			linea_prestamo = "";
			linea_prestamo += p.getUsuario_a_prestar().getDni() + ":"
					+ p.getJuego_a_prestar().getNombre() + ":"
					+ new SimpleDateFormat("dd-MM-YYYY").format(p.getFecha_de_prestamos())+ ":"
					+ new SimpleDateFormat("dd-MM-YYYY").format(p.getFecha_a_devolver()) + "\n";
					
			salida_de_datos_por_fichero.escribirLinea(linea_prestamo);
		}

	}

	@Override
	public Prestamo[] consultarPrestamos() {
		
		return listaPrestamos.toArray(new Prestamo[listaPrestamos.size()]);
	}

}
