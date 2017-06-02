/**
 * 
 */
package com.tetris.logic.blocks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * @author florianhofer
 *
 */
public class SBlock extends Block{

	/**
	 * 
	 */
	
	private FallingParticle start;
	private ParticleWithPosition p1;
	private ParticleWithPosition p2;
	private ParticleWithPosition p3;
	
	public SBlock(int x, int y, List<ParticleWithPosition> existierendenPartikel) {
		// TODO Auto-generated constructor stub
		super(existierendenPartikel);
		this.particles=new ArrayList<>();
		this.start=new FallingParticle(Color.GREEN,x,y);
		
		this.p1=new ParticleWithPosition(Color.GREEN,0,0);
		this.p2=new ParticleWithPosition(Color.GREEN,0,0);
		this.p3=new ParticleWithPosition(Color.GREEN,0,0);
		
		
		
		
		this.p1.setLinksVon(this.p2);
		this.p1.setUeber(this.start);
		this.p2.setRechtsVon(this.p1);
		this.start.setUnter(this.p1);
		this.start.setRechtsVon(this.p3);
		this.p3.setLinksVon(this.start);
		
		
		particles.add(start);
		particles.add(p1);
		particles.add(p2);
		particles.add(p3);
		
		getBlockMatrix().add(new int[][]{
            {0, 0, 0, 0},
            {0, 5, 5, 0},
            {5, 5, 0, 0},
            {0, 0, 0, 0}
    });
		getBlockMatrix().add(new int[][]{
            {5, 0, 0, 0},
            {5, 5, 0, 0},
            {0, 5, 0, 0},
            {0, 0, 0, 0}
    });
	}

	public ArrayList<ParticleWithPosition> getParticles() {
		return particles;
	}

	public void setParticles(ArrayList<ParticleWithPosition> particles) {
		this.particles = particles;
	}

	

	public void setStart(FallingParticle start) {
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
		
	public void updateParticles() {
		start.update();
		p1.update();
		p2.update();
		p3.update();
		
	}
	public FallingParticle getStart() {
		return start;
	}



}
