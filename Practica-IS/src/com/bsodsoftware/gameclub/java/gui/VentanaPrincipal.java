package com.bsodsoftware.gameclub.java.gui;

import imangenes.Imagenes;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.bsodsoftware.gameclub.java.main.Manager;

public class VentanaPrincipal extends JFrame {
	
	private static final long serialVersionUID = 1L;

	/**
	 * El título de la ventana
	 * 
	 * @param titulo
	 */
	public VentanaPrincipal(String titulo) {
		setBounds(0, 0, 700, 500);
		setMinimumSize(new Dimension(700, 500));
		setLayout(null);
		
//		JMenuBar barraMenus = new JMenuBar();
//		
//		JMenu menuArchivoItem = new JMenu("Archivo");
//		
//		JMenuItem report = new JMenuItem("Report");
//		
//		report.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//				getContentPane().setLayout(new BorderLayout());
//				
//				JButton but = new JButton("REPORT");
//			
//				but.addActionListener(new ActionListener() {
//
//					@Override
//					public void actionPerformed(ActionEvent e) {
//						JDialog d = new JDialog();
//						
//						d.setBounds(0,0,200,200);
//						
//						JButton b = new JButton();
//						
//						b.setIcon(Imagenes.getJL());
//						
//						d.add(b);
//						
//						d.setVisible(true);
//					}
//				});
//				
//				getContentPane().add(but, BorderLayout.CENTER);
//				
//				pack();
//			}
//		});
//		
//		menuArchivoItem.add(report);
//		barraMenus.add(menuArchivoItem);
//		
//		setJMenuBar(barraMenus);
		JPanel p = new ToolBarDemo();
			
		
	
		add(p);
	
		pack();
		
		p.setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
