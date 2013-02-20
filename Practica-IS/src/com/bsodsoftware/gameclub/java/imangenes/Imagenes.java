package com.bsodsoftware.gameclub.java.imangenes;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Imagenes {
	
	private static ImageIcon cachedIcon;
	
	public static ImageIcon getJL() {
		cachedIcon = new ImageIcon(Imagenes.class.getResource("./JL.jpg"));
		
		return getCachedIcon();
	}
	
	public static ImageIcon getJL56_56() {
		cachedIcon = new ImageIcon(getJL().getImage().getScaledInstance(56, 56, Image.SCALE_FAST));
		
		return getCachedIcon();
	}
	
	public static ImageIcon getCachedIcon() {
		return cachedIcon;
	}
}
