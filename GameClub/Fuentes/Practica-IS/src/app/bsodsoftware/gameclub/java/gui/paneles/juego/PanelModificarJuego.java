package app.bsodsoftware.gameclub.java.gui.paneles.juego;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
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
import app.bsodsoftware.gameclub.java.gui.tablas.modelos.ModeloJuego;
import app.bsodsoftware.gameclub.java.gui.ventanas.VentanaPrincipal;
import app.bsodsoftware.gameclub.java.modelo.Sistema;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class PanelModificarJuego extends JPanel {

	private static final long serialVersionUID = 1L;

	private Sistema miSistema;
	private VentanaPrincipal ventana;

	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblNombre;
	private JTextField tNombre;
	private JLabel lblTlf;
	private JLabel lblApellidos;
	private JTextField tNjugadores;
	private JButton btnFiltrar;
	private ModeloJuego model;
	private JButton btnModificar;
	private JSeparator separator;
	private JLabel lblDni;
	private JTextField tSNombre;
	private JTextField tUnidades;
	private JLabel lblFechaSancin;
	private JTextField tEdad;
	private JLabel lblFechaDeNacimiento;
	private JTextField tDescripcion;
	private JButton btnCancelar;
	/**
	 * @wbp.nonvisual location=351,621
	 */
	private final JTextField tId = new JTextField();

	/**
	 * Create the panel.
	 */
	public PanelModificarJuego(Sistema sistema, VentanaPrincipal ventanaPadre) {
		tId.setColumns(10);
		setLayout(new BorderLayout(0, 0));

		init();

		miSistema = sistema;
		ventana = ventanaPadre;

		cargarTabla();
	}

	private void init() {

		model = new ModeloJuego();

		table = new MiTabla(model);
		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				if (table.getSelectedRowCount() > 0) {

					int rowSelected = table.getSelectedRow();

					Juego juego = model.getJuego(rowSelected);

					bindJuego(juego);
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

		lblDni = new JLabel("Nombre:");
		lblDni.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblDni, "6, 3");

		tSNombre = new JTextField();
		panel.add(tSNombre, "10, 3, fill, default");
		tSNombre.setColumns(10);

		// Lisener para el botón filtrar
		ActionListener listenerBotonFiltrar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String filtro = tSNombre.getText().trim();

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

		lblFechaSancin = new JLabel("Edad mínima:");
		panel.add(lblFechaSancin, "10, 6, right, default");

		tEdad = new JTextField();
		tEdad.setEditable(false);
		panel.add(tEdad, "12, 6, fill, default");
		tEdad.setColumns(10);

		lblApellidos = new JLabel("Nº de jugadores:");
		panel.add(lblApellidos, "4, 8");

		tNjugadores = new JTextField();
		tNjugadores.setEditable(false);
		panel.add(tNjugadores, "6, 8, fill, default");
		tNjugadores.setColumns(10);

		lblFechaDeNacimiento = new JLabel("Descrpción:");
		panel.add(lblFechaDeNacimiento, "10, 8, right, default");

		tDescripcion = new JTextField();
		tDescripcion.setEditable(false);
		panel.add(tDescripcion, "12, 8, fill, default");
		tDescripcion.setColumns(10);

		lblTlf = new JLabel("Unidades:");
		panel.add(lblTlf, "4, 10, right, default");

		tUnidades = new JTextField();
		tUnidades.setEditable(false);
		panel.add(tUnidades, "6, 10, fill, default");
		tUnidades.setColumns(10);
		
				btnModificar = new JButton("Modificar");
				btnModificar.setEnabled(false);
				
						// Lisener para crear un préstamo.
						btnModificar.addActionListener(new ActionListener() {
				
							@Override
							public void actionPerformed(ActionEvent e) {
				
								Juego juego = miSistema.buscaJuego(tNombre.getText());
				
								try {
									
									ImageIcon imagenAnterior = juego.getImagen() != null ? juego.getImagen() : new ImageIcon();
									
									juego = new Juego( Integer.valueOf(tId.getText()),
														tNombre.getText(),
														Integer.valueOf(tNjugadores.getText()),
														Integer.valueOf(tUnidades.getText()),
														Integer.valueOf(tEdad.getText()),
														tDescripcion.getText(), 
														imagenAnterior
													);
				
									if ( miSistema.modificarjuego(juego) ) {
										
										// Se actualiza el dato en la vista.
										int indice = model.buscar(juego);
										
										model.modificar(indice, juego);
										
										JOptionPane.showMessageDialog(ventana, "Modificación correcta.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
									} else {
										JOptionPane.showMessageDialog(ventana, "Error al modificar el juego.", "Error", JOptionPane.ERROR_MESSAGE);
									}
								} catch (Exception ex) {
									ex.printStackTrace();
									JOptionPane.showMessageDialog(ventana, "Revise los campos.", "Error", JOptionPane.ERROR_MESSAGE);
								}
							}
						});
						btnModificar.setActionCommand("Prestar");
						panel.add(btnModificar, "10, 12");
		
				btnCancelar = new JButton("Cancelar");
				btnCancelar.setEnabled(false);
				btnCancelar.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						unBindUsuario();
					}
				});
				panel.add(btnCancelar, "12, 12");
	}

	/**
	 * Rellena los campos con los datos del usuario.
	 * 
	 * @param juego
	 *            Usuario seleccionado.
	 */
	private void bindJuego(Juego juego) {
		try {

			tId.setText( String.valueOf(juego.getId()));
			tSNombre.setEditable(true);
			tSNombre.setText(juego.getNombre());
			tNombre.setText(juego.getNombre());
			tNombre.setEditable(true);
			tNjugadores.setText( String.valueOf(juego.getNum_jugadores()) );
			tNjugadores.setEditable(true);
			tUnidades.setText(String.valueOf(juego.getUnidades()));
			tUnidades.setEditable(true);
			tEdad.setText( String.valueOf(juego.getEdad_minima()) );
			tEdad.setEditable(true);
			tDescripcion.setText(juego.getDescripcion());
			tDescripcion.setEditable(true);

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
		tId.setText("");
		tSNombre.setText("");
		tSNombre.setEditable(false);
		tNombre.setText("");
		tNombre.setEditable(false);
		tNjugadores.setText("");
		tNjugadores.setEditable(false);
		tUnidades.setText("");
		tUnidades.setEditable(false);
		tEdad.setText("");
		tEdad.setEditable(false);
		tDescripcion.setText("");
		tDescripcion.setEditable(false);

		btnModificar.setEnabled(false);
		btnCancelar.setEnabled(false);
	}

	/**
	 * Método que rellena la tabla con los datos del sistema.
	 */
	private void cargarTabla() {
		Juego[] juego = miSistema.consultarJuegos();

		// Configuro los nuevos datos en el modelo de la tabla.
		model.setObjetos(juego);

		model.rellenar();
	}
}
