package com.bsodsoftware.gameclub.java.gui.ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.UIManager;

import com.bsodsoftware.gameclub.java.gui.paneles.PanelAbout;
import com.bsodsoftware.gameclub.java.gui.paneles.PanelPrestamos;
import com.bsodsoftware.gameclub.java.imagenes.Imagenes;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;

	private static JPanel panel;

	public VentanaPrincipal() {
		/*
		 * Se invoca al constructor que tiene controlados los atributos de la
		 * ventana que se construye.
		 */
		new VentanaPrincipal("Game Club");
	}

	/**
	 * La ventana que contiene toda la GUI de la aplicación.
	 * 
	 * @param titulo
	 *            Título de la aplicación.
	 */
	public VentanaPrincipal(String titulo) {
		setBounds(0, 0, 700, 500);
		setMinimumSize(new Dimension(700, 500));

		setLayout(new BorderLayout());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		// Obtenemos una referencia del panel principal
		// para poder hacer los cambio de panel.
		panel = (JPanel) getContentPane();

		// Inicializamos los botones y paneles.
		Init();
	}

	/**
	 * Método que crea los componenetes de la ventana.
	 */
	private void Init() {

		crearBarraMenus(this);

		panel.add(crearBotones(), BorderLayout.WEST);
	}

	/**
	 * Crea la barra de menús superiores de la aplicación.
	 * 
	 * @param ventana
	 *            Ventana principal de la aplicación.
	 */
	private void crearBarraMenus(JFrame ventana) {

		JMenuBar barraMenus = new JMenuBar();

		JMenu menuArchivo = new JMenu("Archivo");
		JMenu menuAyuda = new JMenu("Ayuda");

		JMenuItem menuAboutItem = new JMenuItem("About BSOD Sotfware");
		menuAboutItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog dialogo = new JDialog();

				dialogo.setContentPane(new PanelAbout(Imagenes.getAbout()
						.getImage()));

				dialogo.setModal(true);
				dialogo.setVisible(true);
			}
		});

		menuAyuda.add(menuAboutItem);

		barraMenus.add(menuArchivo);
		barraMenus.add(menuAyuda);

		ventana.setJMenuBar(barraMenus);
	}

	/**
	 * Crea los botones de cada sección de la aplicación.
	 * 
	 * @param panel
	 */
	private JToolBar crearBotones() {
		JToolBar barraBotones = new JToolBar(JToolBar.VERTICAL);

		ImageIcon iconoPrestamo = Imagenes.getPrestamos56x56();
		ImageIcon iconoDevoluciones = Imagenes.getDevoluciones56x56();
		ImageIcon iconoAdministracion = Imagenes.getAdministracion56x56();

		JButton botonPrestamos = new JButton("   Préstamos    ");

		botonPrestamos.setVerticalTextPosition(JLabel.BOTTOM);
		botonPrestamos.setHorizontalTextPosition(JLabel.CENTER);
		botonPrestamos.setIcon(iconoPrestamo);
		botonPrestamos.setIconTextGap(5);

		botonPrestamos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				cambiarPanel(new PanelPrestamos());
			}
		});

		JButton botonDevoluciones = new JButton("  Devoluciones ");

		botonDevoluciones.setVerticalTextPosition(JLabel.BOTTOM);
		botonDevoluciones.setHorizontalTextPosition(JLabel.CENTER);
		botonDevoluciones.setIcon(iconoDevoluciones);
		botonDevoluciones.setIconTextGap(5);

		botonDevoluciones.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				// changeLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
			}
		});

		JButton botonAdministracion = new JButton("Administración");

		botonAdministracion.setVerticalTextPosition(JLabel.BOTTOM);
		botonAdministracion.setHorizontalTextPosition(JLabel.CENTER);
		botonAdministracion.setIcon(iconoAdministracion);
		botonAdministracion.setIconTextGap(5);

		barraBotones.add(Box.createGlue());
		barraBotones.add(botonPrestamos);
		barraBotones.add(botonDevoluciones);
		barraBotones.add(botonAdministracion);
		barraBotones.add(Box.createGlue());

		return barraBotones;
	}

	private void cambiarPanel(JPanel nuevoPanel) {
		panel.add(nuevoPanel);
		pack();
	}

	/**
	 * Método que cambia el Look and Feel de la aplicación.
	 * 
	 * @param classRouteName
	 *            String de la clase (Look and Feel) a poner.
	 */
	@Deprecated
	public static void changeLookAndFeel(String classRouteName) {
		try {
			UIManager.setLookAndFeel(classRouteName);
			panel.repaint();
		} catch (Exception e) {

		}
	}
}
