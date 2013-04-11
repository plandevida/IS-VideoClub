package com.bsodsoftware.gameclub.java.main;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.UIManager;

import com.bsodsoftware.gameclub.java.gui.ventanas.VentanaPrincipal;

/**
 * Clase principal de la aplicación, desde la cual se inicia la interfaz.
 * 
 * @author Daniel Serrano Torres
 */
public class Manager {
	
	private static final Logger logger = Logger.getLogger(Manager.class.getName());
	
	@SuppressWarnings("unused")
	private static VentanaPrincipal gui;
	
	/**
	 * Inicia y configura la aplicación
	 */
	public static void iniciar() { }
	
	/**
	 * Arranca la aplicación
	 */
	public static void ejecutar() {
		
		try {
//			UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception e) {
			logger.log(Level.WARNING, "No se ha podido cargar el look and feel personalizado.");
		}
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                gui = new VentanaPrincipal("Game Club");
            }
        });
	}
	
	/**
	 * Realiza tareas antes de cerrar la aplicación
	 */
	public static void finalizar() { }

	public static void main(String[] args) {
		iniciar();
		ejecutar();
		finalizar();
	}
}
