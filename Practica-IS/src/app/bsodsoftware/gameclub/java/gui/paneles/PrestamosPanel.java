package app.bsodsoftware.gameclub.java.gui.paneles;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import app.bsodsoftware.gameclub.java.entidades.juego.Juego;
import app.bsodsoftware.gameclub.java.gui.tablas.ModeloJuego;
import app.bsodsoftware.gameclub.java.gui.tablas.TablaPrestamos;
import app.bsodsoftware.gameclub.java.imagenes.Imagenes;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;

public class PrestamosPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblNombreDelJuego;
	private JTextField textField;
	private JLabel lblNmeroDeJugadores;
	private JComboBox<Integer> comboBox;
	private JLabel lblDescripcin;
	private JTextField textField_1;
	private JButton btnFiltrar;
	private JRadioButton rdbtnOn;
	private JRadioButton rdbtnOn_1;
	private JRadioButton rdbtnOn_2;
	private ButtonGroup grupoRadioBotones;
	private JPanel panelRadioButtons;

	/**
	 * Create the panel.
	 */
	public PrestamosPanel() {
		setLayout(new BorderLayout(0, 0));

		Juego juego = new Juego("Colonos del Catan", 8, 10, 5,
				"Muy Interesante", Imagenes.getAdministracion56x56());
		Juego juego1 = new Juego("a", 2, 2, 5, "nada",
				Imagenes.getPrestamos56x56());
		Juego juego2 = new Juego("d", 2, 3, 5, "nada",
				Imagenes.getDevoluciones56x56());

		String[] columnas = { "Nombre", "Número de jugadores", "Edad mínima", "Descripción", "Imagen" };

		ModeloJuego model = new ModeloJuego(
				new Juego[] { juego, juego1, juego2 }, columnas);

		table = new TablaPrestamos(model);

		scrollPane = new JScrollPane(table);

		add(scrollPane, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		panel.setMinimumSize(new Dimension(10, 150));
		panel.setPreferredSize(new Dimension(300, 150));
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("pref:grow"),
				FormFactory.GLUE_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		
		panelRadioButtons = new JPanel();
		panel.add(panelRadioButtons, "2, 4, 1, 5, fill, fill");
		panelRadioButtons.setLayout(new GridLayout(0, 1, 0, 0));
		
		grupoRadioBotones = new ButtonGroup();
		
		rdbtnOn = new JRadioButton("ON");
		panelRadioButtons.add(rdbtnOn);
		rdbtnOn.setToolTipText("Permite habilitar este filtro");
		rdbtnOn.setSelected(true);
		grupoRadioBotones.add(rdbtnOn);
		
		rdbtnOn_1 = new JRadioButton("ON");
		panelRadioButtons.add(rdbtnOn_1);
		rdbtnOn_1.setToolTipText("Permite habilitar este filtro");
		grupoRadioBotones.add(rdbtnOn_1);
		
		rdbtnOn_2 = new JRadioButton("ON");
		panelRadioButtons.add(rdbtnOn_2);
		rdbtnOn_2.setToolTipText("Permite habilitar este filtro");
		grupoRadioBotones.add(rdbtnOn_2);
		
		lblNombreDelJuego = new JLabel("Nombre del juego");
		panel.add(lblNombreDelJuego, "6, 4");
		
		textField = new JTextField();
		panel.add(textField, "12, 4, fill, default");
		textField.setColumns(10);
		
		lblDescripcin = new JLabel("Descripción");
		panel.add(lblDescripcin, "6, 6");
		
		textField_1 = new JTextField();
		panel.add(textField_1, "12, 6, fill, default");
		textField_1.setColumns(10);
		
		btnFiltrar = new JButton("Filtrar");
		panel.add(btnFiltrar, "17, 6");
		
		lblNmeroDeJugadores = new JLabel("Número de jugadores");
		panel.add(lblNmeroDeJugadores, "6, 8");
		
		comboBox = new JComboBox<Integer>();
		comboBox.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {2, 4, 6, 8, 10}));
		panel.add(comboBox, "12, 8, fill, default");
	}
}
