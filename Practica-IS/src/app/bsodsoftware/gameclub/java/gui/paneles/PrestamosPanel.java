package app.bsodsoftware.gameclub.java.gui.paneles;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import app.bsodsoftware.gameclub.java.gui.ventanas.VentanaPrincipal;
import app.bsodsoftware.gameclub.java.modelo.Sistema;

public class PrestamosPanel extends JTabbedPane {

	private static final long serialVersionUID = 1L;

	private Sistema miSistema;
	private VentanaPrincipal miVentana;
	
	public PrestamosPanel(Sistema sistema, VentanaPrincipal ventana) {
		
		miSistema = sistema;
		miVentana = ventana;
		
		init();
	}
	
	private void init() {
		
		addTab("Prestamo de juegos", crearPrestamosJuegosPanel());
		addTab("Prestamos", crearPrestamoInfoPanel());
	}
	
	private JPanel crearPrestamosJuegosPanel() {
		
		return new PrestamoJuegosPanel(miSistema, miVentana);
	}
	
	private JPanel crearPrestamoInfoPanel() {
		
		return new PrestamoInfoPanel(miSistema, miVentana);
	}
}
