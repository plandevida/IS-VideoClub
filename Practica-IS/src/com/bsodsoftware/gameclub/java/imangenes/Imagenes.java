package com.bsodsoftware.gameclub.java.imangenes;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Imagenes {
	
	/**
	 * Última imagen cargada.
	 */
	private static ImageIcon cachedIcon;
	
	public static ImageIcon getPrestamos() {
		cachedIcon = new ImageIcon(Imagenes.class.getResource("prestamos.jpg"));
		
		return getCachedIcon();
	}
	
	public static ImageIcon getPrestamos56x56() {
		cachedIcon = new ImageIcon(getPrestamos().getImage().getScaledInstance(56, 56, Image.SCALE_FAST));
		
		return getCachedIcon();
	}
	
	public static ImageIcon getDevoluciones() {
		cachedIcon = new ImageIcon(Imagenes.class.getResource("devoluciones.png"));
		
		return getCachedIcon();
	}
	
	public static ImageIcon getDevoluciones56x56() {
		cachedIcon = new ImageIcon(getDevoluciones().getImage().getScaledInstance(56, 56, Image.SCALE_FAST));
		
		return getCachedIcon();
	}

	public static ImageIcon getAdministracion() {
		cachedIcon = new ImageIcon(Imagenes.class.getResource("administracion.png"));
		
		return getCachedIcon();
	}
	
	public static ImageIcon getAdministracion56x56() {
		cachedIcon = new ImageIcon(getAdministracion().getImage().getScaledInstance(56, 56, Image.SCALE_FAST));
		
		return getCachedIcon();
	}
	
	public static ImageIcon getAbout() {
		cachedIcon = new ImageIcon(Imagenes.class.getResource("aout.jpg"));
		
		return getCachedIcon();
	}
	
	/**
	 * Obtiene la última imagen cargada.
	 * @return
	 */
	public static ImageIcon getCachedIcon() {
		return cachedIcon;
	}
}
