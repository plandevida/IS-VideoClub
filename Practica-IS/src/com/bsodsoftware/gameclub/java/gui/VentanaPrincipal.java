package com.bsodsoftware.gameclub.java.gui;

import imangenes.Imagenes;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.net.URL;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class VentanaPrincipal extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public VentanaPrincipal() {
		/* 
		 * Se invoca al constructor que tiene controlados
		 * los atributos de la ventana que se construye.
		 */
		new VentanaPrincipal("Game Club");
	}
	
	/**
	 * La ventana que contiene toda la GUI de la aplicación.
	 * 
	 * @param titulo Título de la aplicación.
	 */
	public VentanaPrincipal(String titulo) {
		setBounds(0, 0, 700, 500);
		setMinimumSize(new Dimension(700, 500));
		
		crearBarraMenus(this);
		
		crearBotones( (JPanel) getContentPane());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	/**
	 * Crea la barra de menús superiores de la aplicación.
	 * @param ventana Ventana principal de la aplicación.
	 */
	private void crearBarraMenus(JFrame ventana) {
		
		JMenuBar barraMenus = new JMenuBar();
		
		JMenu menuArchivoItem = new JMenu("Archivo");
		
		barraMenus.add(menuArchivoItem);
		
		ventana.setJMenuBar(barraMenus);
	}
	
	/**
	 * Crea los botones de cada sección de la aplicación.
	 * @param panel
	 */
	private void crearBotones(JPanel panel) {
		JToolBar barraBotones = new JToolBar(JToolBar.VERTICAL);
		
		JButton botonPrestamos = new JButton("Préstamos");
		
		URL url = getClass().getResource("/recursos/JL.jpg");
		
		if (url == null) {
			url = getClass().getResource("JL.jpg");
		}
		
		ImageIcon icono = null;
		
		try {
			icono = new ImageIcon(url);
			
			System.out.println(icono);
			
		} catch(NullPointerException nu) {
			
			System.out.println("nulo desde los recursos");
			
			icono = Imagenes.getJL();
		}
		
		System.out.println(icono);
		
		botonPrestamos.setIcon(icono);
//		botonPrestamos.setIconTextGap(5);
		
		JButton botonDevoluciones = new JButton("Devoluciones");
//		botonDevoluciones.setIconTextGap(5);
		
		JButton botonAdministracion = new JButton("Administración");
//		botonAdministracion.setIconTextGap(5);
		
		barraBotones.add(Box.createGlue());
		barraBotones.add(botonPrestamos);
		barraBotones.add(botonDevoluciones);
		barraBotones.add(botonAdministracion);
		barraBotones.add(Box.createGlue());
		
		panel.add(barraBotones, BorderLayout.WEST);
	}
}
