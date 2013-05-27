package app.bsodsoftware.gameclub.java.gui.paneles;

import javax.swing.JDialog;

import app.bsodsoftware.gameclub.java.gui.ventanas.VentanaPrincipal;
import app.bsodsoftware.gameclub.java.imagenes.Imagenes;

public class PanelAbout extends JDialog {

	private static final long serialVersionUID = 1L;

	private VentanaPrincipal ventana;

	public PanelAbout(VentanaPrincipal ventanaPrincipal) {

		ventana = ventanaPrincipal;

		Init();
	}

	private void Init() {

		setBounds(ventana.getWidth() / 2 - this.getWidth() / 2, ventana.getY(),
				Imagenes.getAbout().getIconWidth(), Imagenes.getAbout()
						.getIconHeight());

		add(new PanelImagen(Imagenes.getAbout()));
	}
}
