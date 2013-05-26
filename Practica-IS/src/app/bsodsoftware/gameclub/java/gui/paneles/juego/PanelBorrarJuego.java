package app.bsodsoftware.gameclub.java.gui.paneles.juego;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


import app.bsodsoftware.gameclub.java.entidades.juego.Juego;
import app.bsodsoftware.gameclub.java.gui.tablas.MiTabla;
import app.bsodsoftware.gameclub.java.gui.tablas.ModeloJuego;
import app.bsodsoftware.gameclub.java.gui.ventanas.VentanaPrincipal;
import app.bsodsoftware.gameclub.java.modelo.Sistema;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class PanelBorrarJuego extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTable table;
	private ModeloJuego model;

	private JScrollPane scrollPane;


	private JButton btnBuscar;
	private JSeparator separator;
	private JLabel lblDni;
	private JTextField txtDNI;
	private JButton btnBorrar;
	private JButton btnCancelar;
	private Sistema miSistema;
	private VentanaPrincipal ventanaprincipal;

	/**
	 * Create the panel.
	 */
	public PanelBorrarJuego(Sistema sistema, VentanaPrincipal ventana) {
		setLayout(new BorderLayout(0, 0));
		
		miSistema = sistema;
		ventanaprincipal = ventana;
		init();
		cargarTabla();
	}

	private void init() {
	
		 model = new ModeloJuego();
	
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
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String filtro = "";
				int columna = 0;
				
				// Dependiendo del filtro escogido se determina la columna por la que filtrar.
				
					filtro = txtDNI.getText();
			
				((MiTabla) table).filtrar(filtro, columna);
			
			}
		});
		
	
		
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
		
		
		btnBorrar = new JButton("Borrar");/*
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
		});*/
		panel.add(btnBorrar, "6, 8");
		
		btnCancelar = new JButton("Cancelar");
		panel.add(btnCancelar, "12, 8");
		
	}
	
	private void cargarTabla() {
		Juego[] juegos = miSistema.consultarJuegos();
		
		// Configuro los nuevos datos en el modelo de la tabla.
		model.setObjetos(juegos);
		
		model.rellenar();
	}
}
	


