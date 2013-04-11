package com.bsodsoftware.gameclub.java.main;

import com.bsodsoftware.gameclub.java.gui.ventanas.VentanaPrincipal;

/**
 * Clase principal de la aplicación, desde la cual se inicia la interfaz.
 * 
 * @author Daniel Serrano Torres
 */
public class Manager {
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
