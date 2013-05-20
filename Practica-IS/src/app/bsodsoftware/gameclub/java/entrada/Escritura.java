package app.bsodsoftware.gameclub.java.entrada;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

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
			System.out.println("linea:" + linea);
			escritura.write(linea);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
