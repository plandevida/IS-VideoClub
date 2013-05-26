package app.bsodsoftware.gameclub.java.gui.paneles.usuario;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;

import app.bsodsoftware.gameclub.java.entidades.usuarios.Usuario;
import app.bsodsoftware.gameclub.java.gui.tablas.MiTabla;
import app.bsodsoftware.gameclub.java.gui.tablas.modelos.ModeloUsuarios;
import app.bsodsoftware.gameclub.java.gui.ventanas.VentanaPrincipal;
import app.bsodsoftware.gameclub.java.modelo.Sistema;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;



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
	private JTextField txtFiltro;
	private JButton btnBorrar;
	private JButton btnCancelar;
	private Sistema miSistema;
	private VentanaPrincipal ventanaprincipal;
	private JComboBox<String> comboBox;

	/**
	 * Create the panel.
	 */
	public PanelBorrarUsuario(Sistema sistema, VentanaPrincipal ventana) {
		setLayout(new BorderLayout(0, 0));
		
		miSistema = sistema;
		ventanaprincipal = ventana;
		init();
		cargarTabla();
	}

	private void init() {
	
		 model = new ModeloUsuarios( new Usuario[] {});
	
		table = new MiTabla(model);
	
		scrollPane = new JScrollPane(table);
	
		add(scrollPane, BorderLayout.CENTER);
	
		JPanel panel = new JPanel();
		panel.setMinimumSize(new Dimension(10, 170));
		panel.setPreferredSize(new Dimension(300, 170));
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("47dlu:grow"),
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
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String filtro = "";
				int columna = 0;
				
				switch((String)comboBox.getSelectedItem()) {
				
				 case "DNI": 
				     columna = 0;
				     break;
				
				 case "Nombre": 
				     columna = 1;
				     break;
			     
				 case "Apellidos": 
				     columna = 2;
				     break;
				     
				}
				// Dependiendo del filtro escogido se determina la columna por la que filtrar.
				
					filtro = txtFiltro.getText();
			
				((MiTabla) table).filtrar(filtro, columna);
			
			}
		});
		
		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"DNI", "Nombre", "Apellidos"}));
		panel.add(comboBox, "2, 3, 3, 1, fill, default");
		
		txtFiltro = new JTextField();
		panel.add(txtFiltro, "6, 3, 3, 1, fill, default");
		txtFiltro.setColumns(10);
		btnBuscar.setActionCommand("Prestar");
		panel.add(btnBuscar, "12, 3");	
		separator = new JSeparator();
		panel.add(separator, "2, 4, 21, 1");
		
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int rowSelected = table.getSelectedRow();
				
				Usuario usuario = model.getUsuario(rowSelected);
				
				if(miSistema.existeUsuario(usuario)){
					
					miSistema.borrarUsuario(usuario);
					JOptionPane.showMessageDialog(ventanaprincipal, "Usuario borrado correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
					cargarTabla();
				}
				else{
					
					JOptionPane.showMessageDialog(ventanaprincipal, "No se a podido borrar","Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panel.add(btnBorrar, "6, 8");
		
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
	
