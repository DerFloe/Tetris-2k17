/**
 * 
 */
package com.tetris.game;

import java.util.ArrayList;

import javafx.scene.paint.Color;

/**
 * @author florianhofer
 *
 */
public class OBlock extends Block{

	/**
	 * 
	 */
	private ArrayList<Particle> particles;
	private Particle start;
	private Particle p1;
	private Particle p2;
	private Particle p3;
	
	public OBlock() {
		// TODO Auto-generated constructor stub
		this.particles=new ArrayList<>();
		this.start=new Particle(Color.YELLOW);
		
		this.p1=new Particle(Color.YELLOW);
		this.p2=new Particle(Color.YELLOW);
		this.p3=new Particle(Color.YELLOW);
		
		
		
		
		this.p1.setLinksVon(this.p2);
		this.p1.setUeber(this.p3);
		this.p2.setRechtsVon(this.p1);
		this.p2.setUeber(this.start);
		this.start.setUnter(this.p2);
		this.start.setRechtsVon(this.p3);
		this.p3.setUnter(this.p1);
		this.p3.setLinksVon(this.start);
		
		
		particles.add(start);
		particles.add(p1);
		particles.add(p2);
		particles.add(p3);
	}

	public ArrayList<Particle> getParticles() {
		return particles;
	}

	public void setParticles(ArrayList<Particle> particles) {
		this.particles = particles;
	}

	public Particle getStart() {
		return start;
	}

	public void setStart(Particle start) {
		this.start = start;
	}

	public Particle getP1() {
		return p1;
	}

	public void setP1(Particle p1) {
		this.p1 = p1;
	}

	public Particle getP2() {
		return p2;
	}

	public void setP2(Particle p2) {
		this.p2 = p2;
	}

	public Particle getP3() {
		return p3;
	}

	public void setP3(Particle p3) {
		this.p3 = p3;
	}
		
}
