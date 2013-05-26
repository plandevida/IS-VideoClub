package app.bsodsoftware.gameclub.java.gui.paneles.usuario;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import app.bsodsoftware.gameclub.java.entidades.usuarios.Usuario;
import app.bsodsoftware.gameclub.java.gui.tablas.MiTabla;
import app.bsodsoftware.gameclub.java.gui.tablas.modelos.ModeloUsuarios;
import app.bsodsoftware.gameclub.java.gui.ventanas.VentanaPrincipal;
import app.bsodsoftware.gameclub.java.modelo.Sistema;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class PanelModificarUsurario extends JPanel {

	private static final long serialVersionUID = 1L;

	private Sistema miSistema;
	private VentanaPrincipal ventana;

	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblNombre;
	private JTextField tNombre;
	private JLabel lblTlf;
	private JLabel lblApellidos;
	private JTextField tApellidos;
	private JButton btnFiltrar;
	private ModeloUsuarios model;
	private JButton btnModificar;
	private JSeparator separator;
	private JLabel lblDni;
	private JTextField tDNI;
	private JTextField tTlf;
	private JLabel lblFechaSancin;
	private JTextField tFSancion;
	private JLabel lblFechaDeNacimiento;
	private JTextField tFNacimiento;
	private JLabel lblDireccin;
	private JTextField tDireccion;
	private JCheckBox chckbxSancionado;
	private JButton btnCancelar;

	/**
	 * Create the panel.
	 */
	public PanelModificarUsurario(Sistema sistema, VentanaPrincipal ventanaPadre) {
		setLayout(new BorderLayout(0, 0));

		init();

		miSistema = sistema;
		ventana = ventanaPadre;

		cargarTabla();
	}

	private void init() {

		model = new ModeloUsuarios();

		table = new MiTabla(model);
		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				if (table.getSelectedRowCount() > 0) {

					int rowSelected = table.getSelectedRow();

					Usuario usuario = model.getUsuario(rowSelected);

					bindUsuario(usuario);
				}
			}
		});

		scrollPane = new JScrollPane(table);

		add(scrollPane, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		panel.setMinimumSize(new Dimension(10, 170));
		panel.setPreferredSize(new Dimension(300, 230));
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"), FormFactory.GLUE_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"), }, new RowSpec[] {
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, }));

		lblDni = new JLabel("DNI:");
		lblDni.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblDni, "6, 3");

		tDNI = new JTextField();
		panel.add(tDNI, "10, 3, fill, default");
		tDNI.setColumns(10);

		// Lisener para el botón filtrar
		ActionListener listenerBotonFiltrar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String filtro = tDNI.getText().trim();

				((MiTabla) table).filtrar(filtro, 0);
			}
		};

		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(listenerBotonFiltrar);
		panel.add(btnFiltrar, "12, 3, left, default");

		separator = new JSeparator();
		panel.add(separator, "2, 4, 21, 1");

		lblNombre = new JLabel("Nombre:");
		panel.add(lblNombre, "4, 6");

		tNombre = new JTextField();
		tNombre.setEditable(false);
		panel.add(tNombre, "6, 6, fill, default");
		tNombre.setColumns(10);

		lblFechaSancin = new JLabel("Fecha sanción:");
		panel.add(lblFechaSancin, "10, 6, right, default");

		tFSancion = new JTextField();
		tFSancion.setEditable(false);
		panel.add(tFSancion, "12, 6, fill, default");
		tFSancion.setColumns(10);

		lblApellidos = new JLabel("Apellidos:");
		panel.add(lblApellidos, "4, 8");

		tApellidos = new JTextField();
		tApellidos.setEditable(false);
		panel.add(tApellidos, "6, 8, fill, default");
		tApellidos.setColumns(10);

		lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		panel.add(lblFechaDeNacimiento, "10, 8, right, default");

		tFNacimiento = new JTextField();
		tFNacimiento.setEditable(false);
		panel.add(tFNacimiento, "12, 8, fill, default");
		tFNacimiento.setColumns(10);

		lblTlf = new JLabel("Teléfono:");
		panel.add(lblTlf, "4, 10, right, default");

		tTlf = new JTextField();
		tTlf.setEditable(false);
		panel.add(tTlf, "6, 10, fill, default");
		tTlf.setColumns(10);

		lblDireccin = new JLabel("Dirección:");
		panel.add(lblDireccin, "10, 10, right, default");

		tDireccion = new JTextField();
		tDireccion.setEditable(false);
		panel.add(tDireccion, "12, 10, fill, default");
		tDireccion.setColumns(10);

		chckbxSancionado = new JCheckBox("Sancionado");
		chckbxSancionado.setEnabled(false);
		panel.add(chckbxSancionado, "6, 12");

		btnModificar = new JButton("Modificar");
		btnModificar.setEnabled(false);

		// Lisener para crear un préstamo.
		btnModificar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Usuario usuario = null;

				try {
					usuario = new Usuario(tDNI.getText(), tNombre.getText(),
							tApellidos.getText(), !"".equals(tFNacimiento
									.getText()) ? new SimpleDateFormat(
									"dd-MM-YYY").parse(tFNacimiento.getText())
									: null, tDireccion.getText(), Integer
									.valueOf(tTlf.getText()));

					miSistema.modificarUsuario(usuario);

				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(ventana,
							"Revise los campos.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnModificar.setActionCommand("Prestar");
		panel.add(btnModificar, "10, 14");

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setEnabled(false);
		btnCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				unBindUsuario();
			}
		});
		panel.add(btnCancelar, "12, 14");
	}

	/**
	 * Rellena los campos con los datos del usuario.
	 * 
	 * @param usuario
	 *            Usuario seleccionado.
	 */
	private void bindUsuario(Usuario usuario) {
		try {

			tDNI.setEditable(!tDNI.isEditable());
			tDNI.setText(usuario.getDni());
			tNombre.setText(usuario.getNombre());
			tNombre.setEditable(!tNombre.isEditable());
			tApellidos.setText(usuario.getApellidos());
			tApellidos.setEditable(!tApellidos.isEditable());
			tTlf.setText(String.valueOf(usuario.getTelefono()));
			tTlf.setEditable(!tTlf.isEditable());
			chckbxSancionado.setSelected(usuario.isSancionado());
			chckbxSancionado.setEnabled(!chckbxSancionado.isEnabled());

			String fSancion = usuario.getHasta() != null ? new SimpleDateFormat(
					"dd-MM-YYYY").format(usuario.getHasta()) : "";

			tFSancion.setText(fSancion);
			tFSancion.setEditable(!tFSancion.isEditable());

			String fNacimiento = usuario.getFecha_nacimiento() != null ? new SimpleDateFormat(
					"dd-MM-YYYY").format(usuario.getFecha_nacimiento()) : "";

			tFNacimiento.setText(fNacimiento);
			tFNacimiento.setEditable(!tFNacimiento.isEditable());
			tDireccion.setText(usuario.getDireccion());
			tDireccion.setEditable(!tDireccion.isEditable());

			btnModificar.setEnabled(true);
			btnCancelar.setEnabled(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Vacía los campos y quita la selección del usuario.
	 */
	private void unBindUsuario() {
		tDNI.setText("");
		tDNI.setEditable(!tDNI.isEditable());
		tNombre.setText("");
		tNombre.setEditable(!tNombre.isEditable());
		tApellidos.setText("");
		tApellidos.setEditable(!tApellidos.isEditable());
		tTlf.setText("");
		tTlf.setEditable(!tTlf.isEditable());
		chckbxSancionado.setSelected(false);
		chckbxSancionado.setEnabled(!chckbxSancionado.isEnabled());
		tFSancion.setText("");
		tFSancion.setEditable(!tFSancion.isEditable());
		tFNacimiento.setText("");
		tFNacimiento.setEditable(!tFNacimiento.isEditable());
		tDireccion.setText("");
		tDireccion.setEditable(!tDireccion.isEditable());

		btnModificar.setEnabled(false);
		btnCancelar.setEnabled(false);
	}

	/**
	 * Método que rellena la tabla con los datos del sistema.
	 */
	private void cargarTabla() {
		Usuario[] usuario = miSistema.consultarUsuarios();

		// Configuro los nuevos datos en el modelo de la tabla.
		model.setObjetos(usuario);

		model.rellenar();
	}
}
