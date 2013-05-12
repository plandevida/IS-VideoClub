package app.bsodsoftware.gameclub.java.entrada;

import java.io.*;

/**
 * 
 * Esta clase genera las referencias de tipo BufferStream de la forma más
 * general posible , haciendo posible que sea reutilizable para futuros usos.
 * 
 * @author Juan Luis Perez
 * @author Juan Carlos Marco
 * @author Emilio Alvarez
 * 
 */

public class Lectura {
	private BufferedReader lectura;

	/**
	 * Crea una clase Superlectura que usa la entrada estándar del sistema con
	 * todos los métodos utilizables posibles.
	 * 
	 */
	public Lectura() {
		lectura = new BufferedReader(new InputStreamReader(
				new BufferedInputStream(new DataInputStream(System.in))));

	}

	/**
	 * /** Crea una clase Superlectura que usa una ruta dada para abrir un
	 * fichero con todos los métodos utilizables posibles.
	 * 
	 * @param Fichero
	 *            El fichero a abrir
	 */
	public Lectura(String Fichero) {
		BufferedReader nuevo_lector = null;
		try {
			nuevo_lector = new BufferedReader(new InputStreamReader(
					new BufferedInputStream(new FileInputStream(Fichero))));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lectura = nuevo_lector;

	}

	/**
	 * Procede a leer una linea del bufferStream
	 * 
	 * @return Devuelve una linea con un string.
	 */
	public String leerLinea() {
		String salida = "";
		try {
			if (lectura.ready()) {

				salida = lectura.readLine();
				String[] salidaaux;
				salidaaux = salida.split("\n");
				salida = salidaaux[0];
			}
		} catch (IOException e) {

			e.printStackTrace();
		} finally {

		}
		return salida;
	}

	public String leerHastaFinalDeFichero() {
		String salida = "", aux = "";
		try {
			while ((aux = lectura.readLine()) != null) {
				salida += aux + "\n";
			}
		} catch (IOException e) {

			e.printStackTrace();
		} finally {

		}
		return salida;
	}
}
