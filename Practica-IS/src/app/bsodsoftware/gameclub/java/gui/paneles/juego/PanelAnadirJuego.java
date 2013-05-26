package app.bsodsoftware.gameclub.java.gui.paneles.juego;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import app.bsodsoftware.gameclub.java.entidades.juego.Juego;
import app.bsodsoftware.gameclub.java.gui.ventanas.VentanaPrincipal;
import app.bsodsoftware.gameclub.java.modelo.Sistema;

public class PanelAnadirJuego extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField txtNombre;
	private JTextField txtNJugadores;
	private JTextField txtUnidades;
	private JTextField txtDescripcion;
	private Sistema miSistema;
	private VentanaPrincipal ventana;
	private JTextField txtEdadminima;

	/**
	 * Create the panel.
	 */
	public PanelAnadirJuego(Sistema sistema, VentanaPrincipal ventana) {

		init();
		miSistema = sistema;
		this.ventana = ventana;

	}

	private void init() {
		JLabel lblNombre = new JLabel("Nombre");

		JLabel lblNJugadores = new JLabel("Nº Jugadores");

		JLabel lblUnidades = new JLabel("Unidades");

		JLabel lblDescripcion = new JLabel("Descripcion");

		JLabel lblEdadminima = new JLabel("Edad Minima");

		JLabel lblImagen = new JLabel("Imagen");

		txtNombre = new JTextField();
		txtNombre.setColumns(10);

		txtNJugadores = new JTextField();
		txtNJugadores.setColumns(10);

		txtUnidades = new JTextField();
		txtUnidades.setColumns(10);

		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// comprueba que hay datos en los campos
				if (("".equals(txtNombre.getText()))
						|| ("".equals(txtNJugadores.getText()))
						|| ("".equals(txtUnidades.getText()))
						|| ("".equals(txtDescripcion.getText()))
						|| ("".equals(txtEdadminima.getText()))) {
					JOptionPane.showMessageDialog(ventana,
							"Faltan campos por rellenar", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					if (!comprobarEntero(txtNJugadores.getText())
							|| !comprobarEntero(txtUnidades.getText())
							|| !comprobarEntero(txtEdadminima.getText())) {
						txtNJugadores.setText("");
						txtUnidades.setText("");
						txtEdadminima.setText("");
						JOptionPane
								.showMessageDialog(
										ventana,
										"El numero de jugadores, las unidades o la edad minima no son validos",
										"Error", JOptionPane.ERROR_MESSAGE);
					} else {
						int idRandom = new Random().nextInt(100000000);
						
						Juego juego = new Juego(idRandom,
								txtNombre.getText(), Integer.parseInt(txtNJugadores.getText()), 
								Integer.parseInt(txtUnidades.getText()),
								Integer.parseInt(txtEdadminima.getText()),
								txtDescripcion.getText(), null);
						// comprueba si ya existe el usuario
						if (!miSistema.existejuego(juego)) {
							// añade el usuario
							if (miSistema.addjuego(juego)) {

								JOptionPane.showMessageDialog(ventana,
										"Juego añadido correctamente", "Aviso",
										JOptionPane.INFORMATION_MESSAGE);
							} else {
								JOptionPane.showMessageDialog(ventana,
										"No se a podido añadir", "Error",
										JOptionPane.ERROR_MESSAGE);
							}
						} else
							JOptionPane.showMessageDialog(ventana,
									"Ya existe el usuario", "Error",
									JOptionPane.ERROR_MESSAGE);
					}
				}
			}

		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtNombre.setText("");
				txtNJugadores.setText("");
				txtUnidades.setText("");
				txtDescripcion.setText("");
				txtEdadminima.setText("");

			}
		});

		txtEdadminima = new JTextField();
		txtEdadminima.setColumns(10);

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGap(129)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.TRAILING)
																						.addGroup(
																								groupLayout
																										.createSequentialGroup()
																										.addGroup(
																												groupLayout
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addComponent(
																																lblUnidades,
																																GroupLayout.DEFAULT_SIZE,
																																165,
																																Short.MAX_VALUE)
																														.addComponent(
																																lblDescripcion,
																																GroupLayout.DEFAULT_SIZE,
																																165,
																																Short.MAX_VALUE)
																														.addComponent(
																																lblEdadminima,
																																GroupLayout.DEFAULT_SIZE,
																																165,
																																Short.MAX_VALUE)
																														.addComponent(
																																lblNJugadores,
																																GroupLayout.DEFAULT_SIZE,
																																165,
																																Short.MAX_VALUE)
																														.addComponent(
																																lblNombre,
																																GroupLayout.DEFAULT_SIZE,
																																165,
																																Short.MAX_VALUE))
																										.addGap(27))
																						.addGroup(
																								groupLayout
																										.createSequentialGroup()
																										.addComponent(
																												lblImagen,
																												GroupLayout.DEFAULT_SIZE,
																												174,
																												Short.MAX_VALUE)
																										.addGap(18)))
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								txtEdadminima)
																						.addComponent(
																								txtDescripcion)
																						.addComponent(
																								txtUnidades)
																						.addComponent(
																								txtNombre)
																						.addComponent(
																								txtNJugadores,
																								GroupLayout.DEFAULT_SIZE,
																								195,
																								Short.MAX_VALUE)))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGap(188)
																		.addComponent(
																				btnAceptar,
																				GroupLayout.PREFERRED_SIZE,
																				98,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(94)
																		.addComponent(
																				btnCancelar,
																				GroupLayout.PREFERRED_SIZE,
																				117,
																				GroupLayout.PREFERRED_SIZE)))
										.addGap(146)));
		groupLayout
				.setVerticalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGap(71)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																txtNombre,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblNombre))
										.addGap(18)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblNJugadores)
														.addComponent(
																txtNJugadores,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblUnidades)
														.addComponent(
																txtUnidades,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblDescripcion)
														.addComponent(
																txtDescripcion,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblEdadminima)
														.addComponent(
																txtEdadminima,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(29)
										.addComponent(lblImagen)
										.addGap(49)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																btnCancelar)
														.addComponent(
																btnAceptar))
										.addGap(231)));
		groupLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {
				btnAceptar, btnCancelar });
		setLayout(groupLayout);
	}

	private boolean comprobarEntero(String campo) {

		boolean entero = true;
		try {

			Integer.parseInt(campo);

		} catch (NumberFormatException e1) {
			entero = false;
		}
		return entero;
	}
}
