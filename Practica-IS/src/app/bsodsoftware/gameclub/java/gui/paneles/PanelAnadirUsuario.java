package app.bsodsoftware.gameclub.java.gui.paneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelAnadirUsuario extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtDireccion;
	private JTextField txtFechaDeNacimiento;

	/**
	 * Create the panel.
	 */
	public PanelAnadirUsuario() {
	
		JLabel lblDni = new JLabel("DNI");
		
		JLabel lblNombre = new JLabel("Nombre");
		
		JLabel lblApellidos = new JLabel("Apellidos");
		
		JLabel lblDireccion = new JLabel("Direccion");
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		
		JLabel lblTelefono = new JLabel("Teléfono");
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		
		txtFechaDeNacimiento = new JTextField();
		txtFechaDeNacimiento.setColumns(10);
		
		JTextField frmtdtxtfldTelefono = new JTextField();
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(129)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblApellidos, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
						.addComponent(lblDireccion, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
						.addComponent(lblFechaNacimiento, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
						.addComponent(lblTelefono, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
						.addComponent(btnAceptar, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
						.addComponent(lblNombre, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
						.addComponent(lblDni, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCancelar, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
						.addComponent(txtFechaDeNacimiento, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
						.addComponent(txtDireccion, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
						.addComponent(txtApellidos, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
						.addComponent(txtNombre, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
						.addComponent(frmtdtxtfldTelefono, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
						.addComponent(txtDni, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE))
					.addGap(128))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(71)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDni))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNombre))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblApellidos)
						.addComponent(txtApellidos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDireccion)
						.addComponent(txtDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFechaNacimiento)
						.addComponent(txtFechaDeNacimiento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTelefono)
						.addComponent(frmtdtxtfldTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(44)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAceptar)
						.addComponent(btnCancelar))
					.addContainerGap(303, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}
