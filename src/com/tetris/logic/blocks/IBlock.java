/**
 * 
 */
package com.tetris.logic.blocks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * @author florianhofer
 *
 */
public class IBlock extends Block{

	/**
	 * 
	 */
	private ArrayList<ParticleWithPosition> particles;
	private FallingParticle start;
	private ParticleWithPosition p1;
	private ParticleWithPosition p2;
	private ParticleWithPosition p3;
	
	public IBlock(int x, int y){
		// TODO Auto-generated constructor stub
		this.particles=new ArrayList<>();
		this.start=new FallingParticle(Color.AQUA, x, y);
		
		this.p1=new ParticleWithPosition(Color.AQUA,0,0);
		this.p2=new ParticleWithPosition(Color.AQUA,0,0);
		this.p3=new ParticleWithPosition(Color.AQUA,0,0);
		
		
		
		
		this.p3.setRechtsVon(this.start);
		this.p2.setLinksVon(this.start);
		this.p1.setLinksVon(this.p2);
		
		
		
		
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
		
	public void update() {
		start.update();
		p1.update();
		p2.update();
		p3.update();
		
	}

	public List<Rectangle> getRectangles() {
		
		return Arrays.asList(start.getR(),p1.getR(),p2.getR(),p3.getR());
	}
	public FallingParticle getStart() {
		return start;
	}
}
