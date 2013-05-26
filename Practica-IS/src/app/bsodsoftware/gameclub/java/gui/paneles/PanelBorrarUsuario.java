package app.bsodsoftware.gameclub.java.gui.paneles;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


import app.bsodsoftware.gameclub.java.entidades.usuarios.Usuario;
import app.bsodsoftware.gameclub.java.gui.tablas.MiTabla;

import app.bsodsoftware.gameclub.java.gui.tablas.ModeloUsuarios;
import app.bsodsoftware.gameclub.java.modelo.Sistema;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JScrollPane;
import javax.swing.JTable;



public class PanelBorrarUsuario extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTable table;
	private ModeloUsuarios model;

	private JScrollPane scrollPane;


	private JButton btnBuscar;
	private JSeparator separator;
	private JLabel lblDni;
	private JTextField txtDNI;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private Sistema miSistema;

	/**
	 * Create the panel.
	 */
	public PanelBorrarUsuario(Sistema sistema) {
		setLayout(new BorderLayout(0, 0));
		
		miSistema = sistema;
		init();
		cargarTabla();
	}

	private void init() {
	
		 model = new ModeloUsuarios( new Usuario[] {}, ModeloUsuarios.columnas);
	
		table = new MiTabla(model);
	
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
		
		btnBuscar = new JButton("Buscar");
		
	
		
		lblDni = new JLabel("DNI:");
		lblDni.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblDni, "2, 3");
		
		txtDNI = new JTextField();
		panel.add(txtDNI, "6, 3, fill, default");
		txtDNI.setColumns(10);
		btnBuscar.setActionCommand("Prestar");
		panel.add(btnBuscar, "12, 3");	
		separator = new JSeparator();
		panel.add(separator, "2, 4, 21, 1");
		
		
		btnAceptar = new JButton("Aceptar");
		panel.add(btnAceptar, "6, 8");
		
		btnCancelar = new JButton("Cancelar");
		panel.add(btnCancelar, "12, 8");
		
	}
	
	private void cargarTabla() {
		Usuario[] usuario = miSistema.consultarUsuarios();
		
		// Configuro los nuevos datos en el modelo de la tabla.
		model.setObjetos(usuario);
		
		model.rellenar();
	}
}
	