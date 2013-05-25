package app.bsodsoftware.gameclub.java.gui.paneles;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import app.bsodsoftware.gameclub.java.gui.ventanas.VentanaPrincipal;
import app.bsodsoftware.gameclub.java.modelo.Sistema;

public class PrestamosPanel extends JTabbedPane {

	private static final long serialVersionUID = 1L;

	private Sistema miSistema;
	private VentanaPrincipal miVentana;
	
	private PrestamoInfoPanel prestamoInfo;
	
	public PrestamosPanel(Sistema sistema, VentanaPrincipal ventana) {
		
		miSistema = sistema;
		miVentana = ventana;
		
		init();
	}
	
	private void init() {
		
		addTab("Prestamo de juegos", crearPrestamosJuegosPanel());
		
		prestamoInfo = crearPrestamoInfoPanel();
		addTab("Prestamos", prestamoInfo);
		
		addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				prestamoInfo.recargarPrestamos();
			}
		});
	}
	
	private PrestamoJuegosPanel crearPrestamosJuegosPanel() {
		
		return new PrestamoJuegosPanel(miSistema, miVentana);
	}
	
	private PrestamoInfoPanel crearPrestamoInfoPanel() {
		
		return new PrestamoInfoPanel(miSistema);
	}
}
