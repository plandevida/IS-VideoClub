package app.bsodsoftware.gameclub.java.gui.paneles;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import app.bsodsoftware.gameclub.java.entidades.juego.Juego;
import app.bsodsoftware.gameclub.java.gui.tablas.ModeloJuego;
import app.bsodsoftware.gameclub.java.gui.tablas.TablaPrestamos;
import app.bsodsoftware.gameclub.java.imagenes.Imagenes;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PrestamosPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTextField tNombreJuego;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblNmeroDeJugadores;
	private JComboBox comboBox;
	private JLabel lblDescripcin;

	/**
	 * Create the panel.
	 */
	public PrestamosPanel() {
		setLayout(new BorderLayout(0, 0));

		Juego juego = new Juego(1, "Colonos del catán", 8, "Juego de estrategia", 5, Imagenes.getAdministracion56x56());
		Juego juego1 = new Juego(2, "a", 2, "nada", 5, Imagenes.getPrestamos56x56());
		Juego juego2 = new Juego(3, "d", 2, "nada", 5, Imagenes.getDevoluciones56x56());
		
		String[] columnas = { "nombre", "imagen", "numero de jugadores", "descripción" };
		
		ModeloJuego model = new ModeloJuego(new Juego[]{ juego, juego1, juego2 }, columnas);
		
		table = new TablaPrestamos(model);
		
		scrollPane = new JScrollPane(table);
		
		add(scrollPane, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(300, 10));
		add(panel, BorderLayout.EAST);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblNombreDelJugeo = new JLabel("Nombre del jugeo:");
		panel.add(lblNombreDelJugeo, "2, 6, right, default");
		
		tNombreJuego = new JTextField();
		panel.add(tNombreJuego, "4, 6, fill, default");
		tNombreJuego.setColumns(10);
		
		lblNmeroDeJugadores = new JLabel("Número de jugadores");
		panel.add(lblNmeroDeJugadores, "2, 10, right, default");
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"2", "4", "6", "8", "10"}));
		panel.add(comboBox, "4, 10, fill, default");
		
		lblDescripcin = new JLabel("Descripción");
		panel.add(lblDescripcin, "2, 14");

	}

}
