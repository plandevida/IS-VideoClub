package app.bsodsoftware.gameclub.java.gui.paneles;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import app.bsodsoftware.gameclub.java.entidades.juego.Juego;
import app.bsodsoftware.gameclub.java.entidades.prestar.Prestamo;
import app.bsodsoftware.gameclub.java.entidades.usuarios.Usuario;
import app.bsodsoftware.gameclub.java.gui.tablas.ModeloJuego;
import app.bsodsoftware.gameclub.java.gui.tablas.TablaPrestamos;
import app.bsodsoftware.gameclub.java.gui.ventanas.VentanaPrincipal;
import app.bsodsoftware.gameclub.java.modelo.Sistema;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class PrestamosPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private Sistema miSistema;
	private VentanaPrincipal ventana;
	
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
	private ModeloJuego model;
	private JButton btnPrestar;
	private JSeparator separator;
	private JLabel lblDni;
	private JTextField tDNI;

	/**
	 * Create the panel.
	 */
	public PrestamosPanel(Sistema sistema, VentanaPrincipal ventanaPadre) {
		setLayout(new BorderLayout(0, 0));
	
		init();
		
		miSistema = sistema;
		ventana = ventanaPadre;
		
		cargarTabla();
	}

	private void init() {

		model = new ModeloJuego( new Juego[] { /*juego, juego1, juego2*/ }, ModeloJuego.columnas);

		table = new TablaPrestamos(model);

		scrollPane = new JScrollPane(table);

		add(scrollPane, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		panel.setMinimumSize(new Dimension(10, 170));
		panel.setPreferredSize(new Dimension(300, 170));
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("35dlu"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
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
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		btnPrestar = new JButton("Prestar");
		
		// Lisener para crear un préstamo.
		btnPrestar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
						
					if (table.getSelectedRowCount() > 0) {
							int rowSelected = table.getSelectedRow();
							
							Juego juegoAPrestar = model.getJuego(rowSelected);
							
							if ( !"".equals(tDNI.getText()) ) {
								
								Usuario usuario = miSistema.buscaUsuario(tDNI.getText().trim());
							
								if ( usuario != null ) {
									
									Date fechaDevolucion = Calendar.getInstance(new Locale("es")).getTime();
									
									Prestamo prestamo = new Prestamo(usuario, juegoAPrestar, Calendar.getInstance(new Locale("es")).getTime(), fechaDevolucion);
									
									if ( !miSistema.addPrestamo(prestamo) ) {
											JOptionPane.showMessageDialog(ventana, "Error al crear un prestamo.", "Error", JOptionPane.ERROR_MESSAGE);
									}
								} else {
									JOptionPane.showMessageDialog(ventana, "El usuario no existe.", "Error", JOptionPane.ERROR_MESSAGE);
								}
							} else {
								JOptionPane.showMessageDialog(ventana, "Es necesario introducir el DNI (con letra y sin espacios).", "Aviso", JOptionPane.WARNING_MESSAGE);
							}
					} else {
						JOptionPane.showMessageDialog(ventana, "Debe seleccionar un juego.", "Aviso", JOptionPane.WARNING_MESSAGE);
					}
				}
			});
		
		lblDni = new JLabel("DNI:");
		lblDni.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblDni, "2, 3");
		
		tDNI = new JTextField();
		panel.add(tDNI, "6, 3, fill, default");
		tDNI.setColumns(10);
		btnPrestar.setActionCommand("Prestar");
		panel.add(btnPrestar, "12, 3");
		
		separator = new JSeparator();
		panel.add(separator, "2, 4, 21, 1");
		
		
		// Panel que contiene los radio buttons (si no están en un panel no se intercambia entre sí la selección)
		panelRadioButtons = new JPanel();
		panel.add(panelRadioButtons, "2, 6, 3, 5, right, fill");
		panelRadioButtons.setLayout(new GridLayout(0, 1, 0, 0));
		
		grupoRadioBotones = new ButtonGroup();
		
		// Lisener que activa el filtro correspondiente de la lista de juegos.
		ActionListener listenerRadioButton = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				tNombreJuego.setEnabled(rdbtnOn.isSelected());
				tDescripcion.setEnabled(rdbtnOn_1.isSelected());
				cNumeroJugadores.setEnabled(rdbtnOn_2.isSelected());
			}
		};
		
		// Lisener para el botón filtrar
		ActionListener listenerBotonFiltrar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String filtro = "";
				int columna = 0;
				
				if ( tNombreJuego.isEnabled() ) {
					filtro = tNombreJuego.getText();
					columna = Integer.valueOf(rdbtnOn.getActionCommand());
				}
				else if ( tDescripcion.isEnabled() ) {
					filtro = tDescripcion.getText();
					columna = Integer.valueOf(rdbtnOn_1.getActionCommand());
				}
				else if ( cNumeroJugadores.isEnabled() ) { 
					filtro = (String)cNumeroJugadores.getSelectedItem();
					columna = Integer.valueOf(rdbtnOn_2.getActionCommand());
				}
				
				((TablaPrestamos) table).filtrar(filtro, columna);
			}
		};
		
		rdbtnOn = new JRadioButton("");
		rdbtnOn.setHorizontalAlignment(SwingConstants.RIGHT);
		rdbtnOn.setToolTipText("Permite habilitar este filtro");
		rdbtnOn.setSelected(true);
		// Este comando sirve para determinar en que columna se va a filtrar en la tabla
		rdbtnOn.setActionCommand("0");
		rdbtnOn.addActionListener(listenerRadioButton);
		grupoRadioBotones.add(rdbtnOn);
		
		rdbtnOn_1 = new JRadioButton("");
		rdbtnOn_1.setHorizontalAlignment(SwingConstants.RIGHT);
		rdbtnOn_1.setToolTipText("Permite habilitar este filtro");
		// Este comando sirve para determinar en que columna se va a filtrar en la tabla
		rdbtnOn_1.setActionCommand("3");
		rdbtnOn_1.addActionListener(listenerRadioButton);
		grupoRadioBotones.add(rdbtnOn_1);
		
		rdbtnOn_2 = new JRadioButton("");
		rdbtnOn_2.setToolTipText("Permite habilitar este filtro");
		// Este comando sirve para determinar en que columna se va a filtrar en la tabla
		rdbtnOn_2.setActionCommand("1");
		rdbtnOn_2.addActionListener(listenerRadioButton);
		grupoRadioBotones.add(rdbtnOn_2);
		
		//Agrupoamos los botones para que la selección sea única
		panelRadioButtons.add(rdbtnOn);
		panelRadioButtons.add(rdbtnOn_1);
		panelRadioButtons.add(rdbtnOn_2);
		
		lblNombreDelJuego = new JLabel("Nombre del juego");
		panel.add(lblNombreDelJuego, "6, 6");
		
		tNombreJuego = new JTextField();
		panel.add(tNombreJuego, "12, 6, fill, default");
		tNombreJuego.setColumns(10);
		
		lblDescripcin = new JLabel("Descripción");
		panel.add(lblDescripcin, "6, 8");
		
		tDescripcion = new JTextField();
		tDescripcion.setEnabled(false);
		panel.add(tDescripcion, "12, 8, fill, default");
		tDescripcion.setColumns(10);
		
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(listenerBotonFiltrar);
		panel.add(btnFiltrar, "17, 8");
		
		lblNmeroDeJugadores = new JLabel("Número de jugadores");
		panel.add(lblNmeroDeJugadores, "6, 10");
		
		cNumeroJugadores = new JComboBox<String>();
		cNumeroJugadores.setModel(new DefaultComboBoxModel<String>(new String[] { "2", "4", "6", "8", "10" }));
		cNumeroJugadores.setEnabled(false);
		panel.add(cNumeroJugadores, "12, 10, fill, default");
	}
	
	private void cargarTabla() {
		Juego[] juegos = miSistema.consultarJuegos();
		
		model.setObjetos(juegos);
		
		model.rellenar();
	}
}
