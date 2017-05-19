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
public class IBlock extends Block{

	/**
	 * 
	 */
	private ArrayList<ParticleWithPosition> particles;
	private ParticleWithPosition start;
	private ParticleWithPosition p1;
	private ParticleWithPosition p2;
	private ParticleWithPosition p3;
	
	public IBlock(){
		// TODO Auto-generated constructor stub
		this.particles=new ArrayList<>();
		this.start=new ParticleWithPosition(Color.AQUA);
		
		this.p1=new ParticleWithPosition(Color.AQUA);
		this.p2=new ParticleWithPosition(Color.AQUA);
		this.p3=new ParticleWithPosition(Color.AQUA);
		
		this.p1.setLinksVon(this.p2);
		this.p2.setRechtsVon(this.p1);
		this.p2.setLinksVon(this.start);
		this.start.setRechtsVon(this.p2);
		this.start.setLinksVon(this.p3);
		this.p3.setRechtsVon(this.start);
		
		
		particles.add(start);
		particles.add(p1);
		particles.add(p2);
		particles.add(p3);
		
		getBlockMatrix().add(new int[][]{
            {0, 0, 0, 0},
            {1, 1, 1, 1},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
		});
		getBlockMatrix().add(new int[][]{
            {0, 1, 0, 0},
            {0, 1, 0, 0},
            {0, 1, 0, 0},
            {0, 1, 0, 0}
		});
	}

	public ArrayList<ParticleWithPosition> getParticles() {
		return particles;
	}

	public void setParticles(ArrayList<ParticleWithPosition> particles) {
		this.particles = particles;
	}

	public ParticleWithPosition getStart() {
		return start;
	}

	public void setStart(ParticleWithPosition start) {
		this.start = start;
	}

	public ParticleWithPosition getP1() {
		return p1;
	}

	public void setP1(ParticleWithPosition p1) {
		this.p1 = p1;
	}

	public ParticleWithPosition getP2() {
		return p2;
	}

	public void setP2(ParticleWithPosition p2) {
		this.p2 = p2;
	}

	public ParticleWithPosition getP3() {
		return p3;
	}

	public void setP3(ParticleWithPosition p3) {
		this.p3 = p3;
	}
		
}
