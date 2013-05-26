package app.bsodsoftware.gameclub.java.entrada;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

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

	private static final Logger logger = Logger.getLogger(Escritura.class
			.getName());

	private BufferedReader lectura;
	private String ficheroPath;

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

		ficheroPath = Fichero;
		BufferedReader nuevo_lector = null;
		try {
			nuevo_lector = new BufferedReader(new InputStreamReader(
					new BufferedInputStream(new FileInputStream(Fichero))));
		} catch (FileNotFoundException e) {

			logger.log(Level.SEVERE, "**Error al abrir el fichero: \""
					+ ficheroPath + "\"**\n" + e.getStackTrace());
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

			logger.log(Level.SEVERE, "**Error al leer una línea el fichero: \""
					+ ficheroPath + "\"**\n" + e.getStackTrace());
			e.printStackTrace();
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

			logger.log(Level.SEVERE, "**Error al leer el fichero: \""
					+ ficheroPath + "\"**\n" + e.getStackTrace());
			e.printStackTrace();
		} finally {
			cerrarFichero();
		}
		return salida;
	}

	public void cerrarFichero() {
		try {
			lectura.close();
		} catch (IOException e) {

			logger.log(Level.SEVERE, "**Error al cerrar el fichero: \""
					+ ficheroPath + "\"**\n" + e.getStackTrace());
			e.printStackTrace();
		}
	}
}
