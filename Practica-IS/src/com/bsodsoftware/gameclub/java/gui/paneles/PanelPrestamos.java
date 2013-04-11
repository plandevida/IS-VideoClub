package com.bsodsoftware.gameclub.java.gui.paneles;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PanelPrestamos extends JPanel {
	
	public PanelPrestamos() {
		
		add(crear());
		
		setOpaque(true);
	}
	
	private JScrollPane crear() {
		String[] nombresColumnas = {
				"ID",
				"Nombre",
				"# jugadores",
				"Edad",
				"Imagen"
		};
		
		Object[][] datos = {
				{ new Integer(1), "Juegito", new Integer(4), new Integer(10), null }
		};
		
		JTable tabla = new JTable(datos, nombresColumnas);
        tabla.setPreferredScrollableViewportSize(new Dimension(500, 70));
        tabla.setFillsViewportHeight(true);
		
		JScrollPane panelDeslizable = new JScrollPane(tabla);
		
//		JPanel contenedor = new JPanel();
//		contenedor.add(panelDeslizable);
		
		return panelDeslizable;
	}
}
