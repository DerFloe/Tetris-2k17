/**
 * 
 */
package com.tetris.game;

import javafx.scene.paint.Color;

/**
 * @author florianhofer
 *
 */
public class Particle {

	/**
	 * 
	 */
	private Color color;
	private Particle rechtsVon;
	private Particle linksVon;
	private Particle unter;
	private Particle ueber;
	public Particle() {
		// TODO Auto-generated constructor stub
		this(Color.RED);
		
		
	}

	public Particle(Color color) {
		super();
		this.color = color;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Particle getRechtsVon() {
		return rechtsVon;
	}

	public void setRechtsVon(Particle rechtsVon) {
		this.rechtsVon = rechtsVon;
	}

	public Particle getLinksVon() {
		return linksVon;
	}

	public void setLinksVon(Particle linksVon) {
		this.linksVon = linksVon;
	}

	public Particle getUnter() {
		return unter;
	}

	public void setUnter(Particle unter) {
		this.unter = unter;
	}

	public Particle getUeber() {
		return ueber;
	}

	public void setUeber(Particle ueber) {
		this.ueber = ueber;
	}
	

}
