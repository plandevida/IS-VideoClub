package app.bsodsoftware.gameclub.java.entrada;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

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

	private BufferedWriter escritura;

	public Escritura(String fichero) {
		BufferedWriter nuevo_escritor = null;
		try {
			nuevo_escritor = new BufferedWriter(new OutputStreamWriter(
					new BufferedOutputStream(new FileOutputStream(fichero))));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		escritura = nuevo_escritor;

	}

	public void escribirLinea(String linea) {

		try {
			escritura.write(linea);
			escritura.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
