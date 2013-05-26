package app.bsodsoftware.gameclub.java.gui.paneles;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import app.bsodsoftware.gameclub.java.gui.paneles.juego.PanelAnadirJuego;
import app.bsodsoftware.gameclub.java.gui.paneles.juego.PanelBorrarJuego;
import app.bsodsoftware.gameclub.java.gui.paneles.usuario.PanelAnadirUsuario;
import app.bsodsoftware.gameclub.java.gui.paneles.usuario.PanelBorrarUsuario;
import app.bsodsoftware.gameclub.java.gui.ventanas.VentanaPrincipal;
import app.bsodsoftware.gameclub.java.modelo.Sistema;

public class PanelAdministraciones extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private Sistema sistema;
	private VentanaPrincipal ventana;
	/**
	 * Create the panel.
	 */
	public PanelAdministraciones(Sistema sistema, VentanaPrincipal ventanaPadre ) {
		init();
		
		this.sistema = sistema;
		ventana = ventanaPadre;
	}
	
	private void init(){
		setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		add(menuBar, BorderLayout.NORTH);
		
		JMenu mnUsuarios = new JMenu("Usuarios");
		menuBar.add(mnUsuarios);
		
		JMenuItem mntmAnadir_usuario = new JMenuItem("Añadir");
		mnUsuarios.add(mntmAnadir_usuario);
		mntmAnadir_usuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				borraPanelCentral();
				
				add(new PanelAnadirUsuario(sistema,ventana), BorderLayout.CENTER);
				// Este método hace que se vea el panel nuevo en tiempo de ejecución.
				validate();
				
			}
		});
		
		JMenuItem mntmBorrar_usuario = new JMenuItem("Borrar");
		mnUsuarios.add(mntmBorrar_usuario);
		mntmBorrar_usuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				borraPanelCentral();
				
				add(new PanelBorrarUsuario(sistema,ventana), BorderLayout.CENTER);
				// Este método hace que se vea el panel nuevo en tiempo de ejecución.
				validate();
				
			}
		});
		
		JMenuItem mntmModificar_usuario = new JMenuItem("Modificar");
		mnUsuarios.add(mntmModificar_usuario);
		
		JMenu mnJuegos = new JMenu("Juegos");
		menuBar.add(mnJuegos);
		
		JMenuItem mntmAnadir_juego = new JMenuItem("Añadir");
		mnJuegos.add(mntmAnadir_juego);
		mntmAnadir_juego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				borraPanelCentral();
				
				add(new PanelAnadirJuego(sistema,ventana), BorderLayout.CENTER);
				// Este método hace que se vea el panel nuevo en tiempo de ejecución.
				validate();
				
			}
		});
				
		
		JMenuItem mntmBorrar_juego = new JMenuItem("Borrar");
		mnJuegos.add(mntmBorrar_juego);
		mntmBorrar_juego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				borraPanelCentral();
				
				add(new PanelBorrarJuego(sistema,ventana), BorderLayout.CENTER);
				// Este método hace que se vea el panel nuevo en tiempo de ejecución.
				validate();
				
			}
		});
		
		JMenuItem mntmModificar_juego = new JMenuItem("Modificar");
		mnJuegos.add(mntmModificar_juego);
	}
	private void borraPanelCentral() {
		BorderLayout layout  = (BorderLayout) getLayout();
		
	
		JPanel panelAnterior = (JPanel) layout.getLayoutComponent(BorderLayout.CENTER);
		
		if ( panelAnterior != null ) {
			// Se borra el panel anterior.
			remove(panelAnterior);
		}
	}

}
