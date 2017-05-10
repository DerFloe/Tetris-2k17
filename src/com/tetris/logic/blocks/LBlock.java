/**
 * 
 */
package com.tetris.logic.blocks;

import java.util.ArrayList;

import javafx.scene.paint.Color;

/**
 * @author florianhofer
 *
 */
public class LBlock extends Block{

	/**
	 * 
	 */
	private ArrayList<Particle> particles;
	private Particle start;
	private Particle p1;
	private Particle p2;
	private Particle p3;
	
	public LBlock() {
		// TODO Auto-generated constructor stub
		this.particles=new ArrayList<>();
		this.start=new Particle(Color.ORANGE);
		
		this.p1=new Particle(Color.ORANGE);
		this.p2=new Particle(Color.ORANGE);
		this.p3=new Particle(Color.ORANGE);
		
		
		
		
		this.p1.setUeber(this.p3);
		this.p2.setLinksVon(this.start);
		this.start.setRechtsVon(this.p2);
		this.start.setLinksVon(this.p3);
		this.p3.setRechtsVon(this.start);
		this.p3.setUnter(this.p1);
		
		
		particles.add(start);
		particles.add(p1);
		particles.add(p2);
		particles.add(p3);
		
		 getBlockMatrix().add(new int[][]{
             {0, 0, 0, 0},
             {0, 3, 3, 3},
             {0, 3, 0, 0},
             {0, 0, 0, 0}
     });
		 getBlockMatrix().add(new int[][]{
             {0, 0, 0, 0},
             {0, 3, 3, 0},
             {0, 0, 3, 0},
             {0, 0, 3, 0}
     });
		 getBlockMatrix().add(new int[][]{
             {0, 0, 0, 0},
             {0, 0, 3, 0},
             {3, 3, 3, 0},
             {0, 0, 0, 0}
     });
		 getBlockMatrix().add(new int[][]{
             {0, 3, 0, 0},
             {0, 3, 0, 0},
             {0, 3, 3, 0},
             {0, 0, 0, 0}
     });
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
