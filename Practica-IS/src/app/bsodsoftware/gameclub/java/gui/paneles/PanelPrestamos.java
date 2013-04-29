package app.bsodsoftware.gameclub.java.gui.paneles;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PanelPrestamos extends JPanel {

	private static final long serialVersionUID = 1L;

	public PanelPrestamos() {

		add(crear());

		setOpaque(true);
	}

	/**
	 * Crea el contenido del panel.
	 * 
	 * @return Un panel desizable con una tabla.
	 */
	private JScrollPane crear() {
		String[] nombresColumnas = { "ID", "Nombre", "# jugadores", "Edad",
				"Imagen" };

		Object[][] datos = { { new Integer(1), "Juegito", new Integer(4),
				new Integer(10), null } };

		JTable tabla = new JTable(datos, nombresColumnas);
		tabla.setPreferredScrollableViewportSize(new Dimension(500, 70));
		tabla.setFillsViewportHeight(true);

		JScrollPane panelDeslizable = new JScrollPane(tabla);

		return panelDeslizable;
	}
}
