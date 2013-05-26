package app.bsodsoftware.gameclub.java.gui.paneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import app.bsodsoftware.gameclub.java.entidades.usuarios.Usuario;
import app.bsodsoftware.gameclub.java.gui.ventanas.VentanaPrincipal;
import app.bsodsoftware.gameclub.java.modelo.Sistema;
import com.toedter.calendar.JCalendar;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PanelAnadirUsuario extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private Sistema miSistema;
	private JCalendar calendar;
	private VentanaPrincipal ventana;

	/**
	 * Create the panel.
	 */
	public PanelAnadirUsuario(Sistema sistema, VentanaPrincipal ventana) {
		
		init();
		miSistema = sistema;
		this.ventana = ventana;
 
	}
	
	private void  init(){
		JLabel lblDni = new JLabel("DNI");
		
		JLabel lblNombre = new JLabel("Nombre");
		
		JLabel lblApellidos = new JLabel("Apellidos");
		
		JLabel lblDireccion = new JLabel("Direccion");
		
		JLabel lblTelefono = new JLabel("Teléfono");
		
		JLabel lblFechanacimiento = new JLabel("Fecha de Nacimiento");
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtDni.getText().equals("") && txtNombre.getText().equals("") && txtApellidos.getText().equals("") && calendar.getDate()==null && txtDireccion.getText().equals("") && txtTelefono.getText().equals("")){
					JOptionPane.showMessageDialog(ventana, "Faltan campos por rellenar", "Error", JOptionPane.ERROR_MESSAGE);
				}
				miSistema.addUsuario(new Usuario(txtDni.getText(), txtNombre.getText(), txtApellidos.getText(), calendar.getDate(), txtDireccion.getText(), Integer.parseInt(txtTelefono.getText())));
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		
		calendar = new JCalendar();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(129)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnAceptar, GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCancelar, GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblApellidos, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
								.addComponent(lblDireccion, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
								.addComponent(lblTelefono, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
								.addComponent(lblFechanacimiento, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
								.addComponent(lblNombre, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
								.addComponent(lblDni, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE))
							.addGap(27)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(calendar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtTelefono, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
								.addComponent(txtDireccion, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
								.addComponent(txtApellidos, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
								.addComponent(txtNombre, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
								.addComponent(txtDni, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE))))
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
						.addComponent(lblTelefono)
						.addComponent(txtTelefono, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFechanacimiento)
						.addComponent(calendar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(15)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnAceptar))
					.addContainerGap(198, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
}
