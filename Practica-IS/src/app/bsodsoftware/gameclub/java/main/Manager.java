package app.bsodsoftware.gameclub.java.main;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.UIManager;

import app.bsodsoftware.gameclub.java.entidades.juego.Juego;
import app.bsodsoftware.gameclub.java.entidades.prestar.Prestamo;
import app.bsodsoftware.gameclub.java.entidades.usuarios.Usuario;
import app.bsodsoftware.gameclub.java.gui.ventanas.VentanaPrincipal;
import app.bsodsoftware.gameclub.java.modelo.controlador.Sistema;


/**
 * Clase principal de la aplicación, desde la cual se inicia la interfaz.
 * 
 * @author Daniel Serrano Torres
 */
public class Manager {

	private Sistema sistema;

	private static final Logger logger = Logger.getLogger(Manager.class
			.getName());

	@SuppressWarnings("unused")
	private VentanaPrincipal gui;
	private String titulo;

	/**
	 * Inicia y configura la aplicación
	 */
	public void iniciar() {
		titulo = "Video Game Club";
		ArrayList<Usuario> listaUsuarios= new ArrayList<Usuario>();
		ArrayList<Juego> listaJuegos = new ArrayList<Juego>(); 
		ArrayList<Prestamo> listaPrestamos = new ArrayList<Prestamo>(); 
		
		listaUsuarios.add(new Usuario("12345678A", "Juan", "Trama"));
		
		listaJuegos.add(new Juego(0, "Colonos del Catan", "Muy Interesante", 5));
		// SE CARGAN LOS DATOS
		
		
		
		sistema= new Sistema(listaUsuarios,listaJuegos,listaPrestamos);
		
		
	}

	/**
	 * Arranca la aplicación
	 */
	public void ejecutar() {

		try {
			// UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
			UIManager
					.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			logger.log(Level.WARNING,
					"No se ha podido cargar el look and feel personalizado.");
		}

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				gui = new VentanaPrincipal(titulo);
			}
		});
	}

	/**
	 * Realiza tareas antes de cerrar la aplicación
	 */
	public void finalizar() {
		
		
	}

	public static void main(String[] args) {
		Manager manager = new Manager();
	
		manager.iniciar();
		manager.ejecutar();
		manager.finalizar();
	}
}
