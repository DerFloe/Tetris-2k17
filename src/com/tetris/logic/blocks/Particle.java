/**
 * 
 */
package com.tetris.logic.blocks;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * @author florianhofer
 *
 */
public class Particle {

	/**
	 * 
	 */
	private static int counter = -1;

	    // Instanzvariable
	private int num;
	protected Rectangle r;
	private Color color;

	public Particle() {
		// TODO Auto-generated constructor stub
		this(Color.WHITE);
		
		
	}

	public Particle(Color color) {
		super();
		this.color = color;
		counter++;
        num = counter;
        
        r= new Rectangle(0,0,20,20);
        r.setStroke(Color.GRAY);
        r.setFill(color);
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





	public Rectangle getR() {
		return r;
	}

	public int getNum() {
		return num;
	}

	
	

}
