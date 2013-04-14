package com.bsodsoftware.gameclub.java.gui.paneles;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class PanelAbout extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private Image foto;
	
	public PanelAbout(Image imagen) {
		foto = imagen;
		
		Init();
	}
	
	private void Init() {
		setBounds(0, 0, 300, 300);
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(foto, 0, 0, getWidth(), getHeight(), null);
	}
}
