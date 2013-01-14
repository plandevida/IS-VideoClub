package com.bsodsoftware.gameclub.java.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class VentanaPrincipal extends JFrame {
	
	/**
	 * El título de la ventana
	 * 
	 * @param titulo
	 */
	public VentanaPrincipal(String titulo) {
		setBounds(0, 0, 700, 500);
		setMinimumSize(new Dimension(700, 500));
		setLayout(null);
		
		JMenuBar barraMenus = new JMenuBar();
		
		JMenu menuArchivoItem = new JMenu("Archivo");
		
		JMenuItem report = new JMenuItem("Report");
		
		report.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				getContentPane().setLayout(new BorderLayout());
				getContentPane().add(new JButton("REPORT"), BorderLayout.CENTER);
				
				pack();
			}
		});
		
		menuArchivoItem.add(report);
		barraMenus.add(menuArchivoItem);
		
		setJMenuBar(barraMenus);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
