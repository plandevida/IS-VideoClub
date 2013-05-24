package app.bsodsoftware.gameclub.java.gui.paneles;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class PanelAdministraciones extends JPanel {
	

	/**
	 * Create the panel.
	 */
	public PanelAdministraciones() {
		setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);
		
		JMenuBar menuBar = new JMenuBar();
		toolBar.add(menuBar);
		
		JMenu mnUsuarios = new JMenu("Usuarios");
		menuBar.add(mnUsuarios);
		
		JMenuItem mntmAnadir_usuario = new JMenuItem("Añadir");
		mnUsuarios.add(mntmAnadir_usuario);
		mntmAnadir_usuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				add(new PanelAnadirUsuario(), BorderLayout.CENTER);
				// Este método hace que se vea el panel nuevo en tiempo de ejecución.
				validate();
				
			}
		});
		
		JMenuItem mntmBorrar_usuario = new JMenuItem("Borrar");
		mnUsuarios.add(mntmBorrar_usuario);
		
		JMenuItem mntmModificar_usuario = new JMenuItem("Modificar");
		mnUsuarios.add(mntmModificar_usuario);
		
		JMenu mnJuegos = new JMenu("Juegos");
		menuBar.add(mnJuegos);
		
		JMenuItem mntmAnadir_juego = new JMenuItem("Añadir");
		mnJuegos.add(mntmAnadir_juego);
		
		JMenuItem mntmBorrar_juego = new JMenuItem("Borrar");
		mnJuegos.add(mntmBorrar_juego);
		
		JMenuItem mntmModificar_juego = new JMenuItem("Modificar");
		mnJuegos.add(mntmModificar_juego);
		
		

	}

}
