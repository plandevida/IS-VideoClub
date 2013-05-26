package app.bsodsoftware.gameclub.java.entrada;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * Esta clase genera las referencias de tipo BuffeWriter de la forma más general
 * posible , haciendo posible que sea reutilizable para futuros usos.
 * 
 * @author Juan Luis Perez
 * @author Daniel Serrano
 * @author Emilio Alvarez
 * @author Alvaro Quesada
 * 
 */

public class Escritura {

	private static final Logger logger = Logger.getLogger(Escritura.class
			.getName());

	private BufferedWriter escritura;
	private String ficheroPath;

	public Escritura(String fichero) {

		ficheroPath = fichero;
		BufferedWriter nuevo_escritor = null;
		try {
			nuevo_escritor = new BufferedWriter(new OutputStreamWriter(
					new BufferedOutputStream(new FileOutputStream(fichero))));
		} catch (FileNotFoundException e) {

			logger.log(Level.SEVERE, "**Error al abrir el fichero: \""
					+ ficheroPath + "\"**\n" + e.getStackTrace());
			e.printStackTrace();
		}
		escritura = nuevo_escritor;

	}

	public void escribirLinea(String linea) {

		try {
			escritura.write(linea);
			escritura.flush();
		} catch (IOException e) {

			logger.log(Level.SEVERE, "**Error al escribir en el fichero: \""
					+ ficheroPath + "\"**\n" + e.getStackTrace());
			e.printStackTrace();
		}
	}

	public void cerrarFichero() {
		try {
			escritura.close();
		} catch (IOException e) {

			logger.log(Level.SEVERE, "**Error al cerrar el fichero: \""
					+ ficheroPath + "\"**\n" + e.getStackTrace());
			e.printStackTrace();
		}
	}
}
