package app.bsodsoftware.gameclub.java.gui.paneles;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import app.bsodsoftware.gameclub.java.entidades.prestar.Prestamo;
import app.bsodsoftware.gameclub.java.gui.tablas.MiTabla;
import app.bsodsoftware.gameclub.java.gui.tablas.ModeloPrestamo;
import app.bsodsoftware.gameclub.java.modelo.Sistema;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class PrestamoInfoPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private Sistema miSistema;
	
	private JTable table;
	private JScrollPane scrollPane;
	private ModeloPrestamo model;
	private JButton btnFiltrar;
	private JLabel lblDni;
	private JTextField tDNI;

	/**
	 * Create the panel.
	 */
	public PrestamoInfoPanel(Sistema sistema) {
		setLayout(new BorderLayout(0, 0));
	
		init();
		
		miSistema = sistema;
		
		cargarTabla();
	}

	private void init() {

		model = new ModeloPrestamo( new Prestamo[] {}, ModeloPrestamo.columnas);

		table = new MiTabla(model);

		scrollPane = new JScrollPane(table);

		add(scrollPane, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		panel.setMinimumSize(new Dimension(10, 170));
		panel.setPreferredSize(new Dimension(300, 70));
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.GLUE_COLSPEC,
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
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,}));
		
		// Lisener para el botón filtrar
		ActionListener listenerBotonFiltrar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String filtro = "";
				int columna = 0;
				
				// Dependiendo del filtro escogido se determina la columna por la que filtrar.
				if ( "".equals(tDNI.getText())) {
					filtro = tDNI.getText();
					columna = Integer.valueOf(0);
				}
				
				((MiTabla) table).filtrar(filtro, columna);
			}
		};
		
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(listenerBotonFiltrar);
		
		lblDni = new JLabel("DNI:");
		lblDni.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblDni, "4, 3");
		
		tDNI = new JTextField();
		panel.add(tDNI, "6, 3, fill, default");
		tDNI.setColumns(10);
		btnFiltrar.setActionCommand("Prestar");
		panel.add(btnFiltrar, "12, 3, left, default");
	}
	
	/**
	 * Método que rellena la tabla con los datos del sistema.
	 */
	private void cargarTabla() {
		Prestamo[] prestamos = miSistema.consultarPrestamos();
		
		// Configuro los nuevos datos en el modelo de la tabla.
		model.setObjetos(prestamos);
		
		model.rellenar();
	}
	
	public void recargarPrestamos() {
		cargarTabla();
	}
}
