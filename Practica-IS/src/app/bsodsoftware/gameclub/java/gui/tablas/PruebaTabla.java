package app.bsodsoftware.gameclub.java.gui.tablas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import app.bsodsoftware.gameclub.java.entidades.juego.Juego;
import app.bsodsoftware.gameclub.java.imagenes.Imagenes;

public class PruebaTabla extends JFrame {

	private static final long serialVersionUID = 1L;

	public PruebaTabla() {
		
		super("Prueba Tabla");
		
		init();
	}
	
	public void init() {
		
		Juego juego = new Juego(1, "Colonos del catán", 8, "Juego de estrategia", 5, Imagenes.getAdministracion56x56());
		Juego juego1 = new Juego(2, "a", 2, "nada", 5, Imagenes.getPrestamos56x56());
		Juego juego2 = new Juego(3, "d", 2, "nada", 5, Imagenes.getDevoluciones56x56());
		
		String[] columnas = { "nombre", "imagen", "numero de jugadores", "descripción" };
		
		ModeloJuego model = new ModeloJuego(new Juego[]{ juego, juego1, juego2 }, columnas);
		
		setBounds(200, 150, 300, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout(5, 5));
		
		final TablaPrestamos tabla = new TablaPrestamos(model);
		
		JScrollPane scrollPane = new JScrollPane(tabla);
		
		add(scrollPane, BorderLayout.CENTER);
		
		final JTextField field = new JTextField();
//		field.setBounds(new Rectangle(100, 20));
		JButton boton = new JButton("filtrar");
		
		boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tabla.newFilter(field.getText());
			}
		});
		
		JPanel panelsur = new JPanel();
		panelsur.setLayout(new GridLayout(1, 2));
		
		panelsur.add(field);
		panelsur.add(boton);
		
		add(panelsur, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new PruebaTabla();
	}

}
