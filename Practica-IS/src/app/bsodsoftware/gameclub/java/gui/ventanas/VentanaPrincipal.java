package app.bsodsoftware.gameclub.java.gui.ventanas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import app.bsodsoftware.gameclub.java.gui.paneles.PanelAbout;
import app.bsodsoftware.gameclub.java.gui.paneles.PrestamoJuegosPanel;
import app.bsodsoftware.gameclub.java.imagenes.Imagenes;
import app.bsodsoftware.gameclub.java.main.Manager;
import app.bsodsoftware.gameclub.java.modelo.Sistema;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 5633360730065002268L;

	private Sistema miSistema;
	
	private Manager miManager;
	
	private JPanel contentPane;
	
	// Creada para poder ser asiganda a un diálogo
	// que está en la implementación de un listener.
	private VentanaPrincipal mySelf;

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(String titulo, Sistema sistema, Manager manager) {
		
		miSistema = sistema;
		
		miManager = manager;
		
		setTitle(titulo);
		// Se usa dispose y no close para poder invocar un método antes del cierre
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// Esto ajusta la ventana al tamaño de la pantalla
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(600, 500));
		
		// Própositos de diálogos.
		mySelf = this;
		
		init();

		setVisible(true);
	}
	
	@Override
	public void dispose() {
		miManager.finalizar();
		System.exit(0);
	}
	
	private void init() {

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				miManager.finalizar();
				
				// Salimos de la applicación
				System.exit(0);
			}
		});
		mnArchivo.add(mntmSalir);

		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		JMenuItem mntmDesarrolladores = new JMenuItem("Desarrolladores");
		mntmDesarrolladores.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// Muestro el panel de bsodsoftware.
				new PanelAbout(mySelf).setVisible(true);
			}
		});
		mnAbout.add(mntmDesarrolladores);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JToolBar toolBar = new JToolBar();
		toolBar.setAlignmentY(Component.CENTER_ALIGNMENT);
		toolBar.setAlignmentX(Component.LEFT_ALIGNMENT);
		toolBar.setOrientation(SwingConstants.VERTICAL);
		contentPane.add(toolBar, BorderLayout.WEST);

		Component verticalGlue = Box.createVerticalGlue();
		toolBar.add(verticalGlue);

		JButton btnPrestamos = new JButton("    Prestamos    ");
		btnPrestamos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Creo un panel nuevo y lo inserto en la ventana.
				getContentPane().add(new PrestamoJuegosPanel(miSistema, mySelf), BorderLayout.CENTER);
				// Este método hace que se vea el panel nuevo en tiempo de ejecución.
				getContentPane().validate();
			}
		});
		btnPrestamos.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnPrestamos
				.setToolTipText("Abre la sección de prestamos de juegos de mesa.");
		btnPrestamos.setIcon(Imagenes.getPrestamos56x56());
		btnPrestamos.setVerticalTextPosition(JButton.BOTTOM);
		btnPrestamos.setHorizontalTextPosition(JLabel.CENTER);
		toolBar.add(btnPrestamos);

		JButton btnDevoluciones = new JButton("  Devoluciones  ");
		btnDevoluciones.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnDevoluciones.setVerticalAlignment(SwingConstants.BOTTOM);
		btnDevoluciones.setIcon(Imagenes.getDevoluciones56x56());
		btnDevoluciones.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnDevoluciones.setHorizontalTextPosition(JButton.CENTER);
		toolBar.add(btnDevoluciones);

		JButton btnAdministracion = new JButton("Administración");
		btnAdministracion.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnAdministracion.setIcon(Imagenes.getAdministracion56x56());
		btnAdministracion.setVerticalTextPosition(JButton.BOTTOM);
		btnAdministracion.setHorizontalTextPosition(JButton.CENTER);
		toolBar.add(btnAdministracion);

		Component verticalGlue_1 = Box.createVerticalGlue();
		toolBar.add(verticalGlue_1);
	}
}
