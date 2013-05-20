package app.bsodsoftware.gameclub.java.gui.paneles;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
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

public class PrestamosPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tNombreJuego;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Create the panel.
	 */
	public PrestamosPanel() {
		setLayout(new BorderLayout(0, 0));

		Juego juego = new Juego("Colonos del Catan", 8, 10, 5,
				"Muy Interesante", new ImageIcon());
		Juego juego1 = new Juego("a", 2, 2, 5, "nada",
				Imagenes.getPrestamos56x56());
		Juego juego2 = new Juego("d", 2, 3, 5, "nada",
				Imagenes.getDevoluciones56x56());

		String[] columnas = { "nombre", "imagen", "numero de jugadores",
				"descripción" };

		ModeloJuego model = new ModeloJuego(
				new Juego[] { juego, juego1, juego2 }, columnas);

		table = new TablaPrestamos(model);

		scrollPane = new JScrollPane(table);

		add(scrollPane, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(300, 10));
		add(panel, BorderLayout.EAST);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"), }, new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, }));

		JLabel lblNombreDelJugeo = new JLabel("Nombre del jugeo:");
		panel.add(lblNombreDelJugeo, "2, 6, right, default");

		tNombreJuego = new JTextField();
		panel.add(tNombreJuego, "4, 6, fill, default");
		tNombreJuego.setColumns(10);

	}

}
