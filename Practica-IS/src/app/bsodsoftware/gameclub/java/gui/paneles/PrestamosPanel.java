package app.bsodsoftware.gameclub.java.gui.paneles;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblNombreDelJuego;
	private JTextField tNombreJuego;
	private JLabel lblNmeroDeJugadores;
	private JComboBox<String> cNumeroJugadores;
	private JLabel lblDescripcin;
	private JTextField tDescripcion;
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

		// Juegos de ejemplo para la tabla
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
				ColumnSpec.decode("35dlu"),
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
		
		
		// Panel que contiene los radio buttons (si no están en un panel no se intercambia entre sí la selección)
		panelRadioButtons = new JPanel();
		panel.add(panelRadioButtons, "2, 4, 1, 5, right, fill");
		panelRadioButtons.setLayout(new GridLayout(0, 1, 0, 0));
		
		grupoRadioBotones = new ButtonGroup();
		
		// Lisener que activa el filtro correspondiente de la lista de juegos.
		ActionListener listenerRadioButton = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String action = e.getActionCommand();
				
				switch (action) {
				
				case "0":
					tNombreJuego.setEditable(true);
					tDescripcion.setEnabled(false);
					cNumeroJugadores.setEnabled(false);
					break;
					
				case "1":
					tNombreJuego.setEditable(false);
					tDescripcion.setEnabled(true);
					cNumeroJugadores.setEnabled(false);
					break;
					
				case "3":
					tNombreJuego.setEditable(false);
					tDescripcion.setEnabled(false);
					cNumeroJugadores.setEnabled(true);
					break;
					
				default:
					tNombreJuego.setEditable(false);
					tDescripcion.setEnabled(false);
					cNumeroJugadores.setEnabled(false);
					break;
				}
			}
		};
		
		// Lisener para el botón filtrar
		ChangeListener listenerBotonFiltrar = new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				
				String filtro = "";
				
				if ( tNombreJuego.isEnabled() ) filtro = tNombreJuego.getText();
				else if ( tDescripcion.isEnabled() ) filtro = tDescripcion.getText();
				else if ( cNumeroJugadores.isEnabled() ) filtro = (String)cNumeroJugadores.getSelectedItem();
				
				((TablaPrestamos) table).filtrar(filtro);
			}
		};
		
		rdbtnOn = new JRadioButton("ON->");
		rdbtnOn.setToolTipText("Permite habilitar este filtro");
		rdbtnOn.setSelected(true);
		// Este comando sirve para determinar en que columna se va a filtrar en la tabla
		rdbtnOn.setActionCommand("0");
		rdbtnOn.addActionListener(listenerRadioButton);
		grupoRadioBotones.add(rdbtnOn);
		
		rdbtnOn_1 = new JRadioButton("ON->");
		rdbtnOn_1.setToolTipText("Permite habilitar este filtro");
		// Este comando sirve para determinar en que columna se va a filtrar en la tabla
		rdbtnOn_1.setActionCommand("1");
		rdbtnOn_1.addActionListener(listenerRadioButton);
		grupoRadioBotones.add(rdbtnOn_1);
		
		rdbtnOn_2 = new JRadioButton("ON->");
		rdbtnOn_2.setToolTipText("Permite habilitar este filtro");
		// Este comando sirve para determinar en que columna se va a filtrar en la tabla
		rdbtnOn_2.setActionCommand("3");
		rdbtnOn_2.addActionListener(listenerRadioButton);
		grupoRadioBotones.add(rdbtnOn_2);
		
		//Agrupoamos los botones para que la selección sea única
		panelRadioButtons.add(rdbtnOn);
		panelRadioButtons.add(rdbtnOn_1);
		panelRadioButtons.add(rdbtnOn_2);
		
		lblNombreDelJuego = new JLabel("Nombre del juego");
		panel.add(lblNombreDelJuego, "6, 4");
		
		tNombreJuego = new JTextField();
		panel.add(tNombreJuego, "12, 4, fill, default");
		tNombreJuego.setColumns(10);
		
		lblDescripcin = new JLabel("Descripción");
		panel.add(lblDescripcin, "6, 6");
		
		tDescripcion = new JTextField();
		tDescripcion.setEnabled(false);
		panel.add(tDescripcion, "12, 6, fill, default");
		tDescripcion.setColumns(10);
		
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addChangeListener(listenerBotonFiltrar);
		panel.add(btnFiltrar, "17, 6");
		
		lblNmeroDeJugadores = new JLabel("Número de jugadores");
		panel.add(lblNmeroDeJugadores, "6, 8");
		
		cNumeroJugadores = new JComboBox<String>();
		cNumeroJugadores.setModel(new DefaultComboBoxModel<String>(new String[] { "2", "4", "6", "8", "10" }));
		cNumeroJugadores.setEnabled(false);
		panel.add(cNumeroJugadores, "12, 8, fill, default");
	}
}
