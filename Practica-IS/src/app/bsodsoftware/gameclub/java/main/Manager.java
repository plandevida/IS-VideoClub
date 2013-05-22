package app.bsodsoftware.gameclub.java.main;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.UIManager;

import app.bsodsoftware.gameclub.java.gui.ventanas.VentanaPrincipal;
import app.bsodsoftware.gameclub.java.modelo.Sistema;

/**
 * Clase principal de la aplicación, desde la cual se inicia la interfaz.
 * 
 * @author Daniel Serrano Torres
 */
public class Manager {

	private static final Logger logger = Logger.getLogger(Manager.class.getName());

	@SuppressWarnings("unused")
	private VentanaPrincipal gui;
	private String titulo;
	
	private Sistema sistema;

	/**
	 * Inicia y configura la aplicación
	 */
	public void iniciar() {
		titulo = "Video Game Club";

		sistema = new Sistema();
	}

	/**
	 * Arranca la aplicación
	 */
	public void ejecutar() {

		try {
			// UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			logger.log(Level.WARNING, "No se ha podido cargar el look and feel personalizado.");
		}

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				gui = new VentanaPrincipal(titulo, sistema);
			}
		});
	}

	/**
	 * Realiza tareas antes de cerrar la aplicación
	 */
	public void finalizar() {
		
		sistema.escribirFichero();
	}

	public static void main(String[] args) {
		Manager manager = new Manager();

		manager.iniciar();
		manager.ejecutar();
		manager.finalizar();
	}
}
