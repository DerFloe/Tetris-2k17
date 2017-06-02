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
public class ZBlock extends Block{

	/**
	 * 
	 */
	private ArrayList<Particle> particles;
	private FallingParticle start;
	private ParticleWithPosition p1;
	private ParticleWithPosition p2;
	private ParticleWithPosition p3;
	
	public ZBlock(int x, int y, List<ParticleWithPosition> existierendenPartikel) {
		// TODO Auto-generated constructor stub
		super(existierendenPartikel);
		this.particles=new ArrayList<>();
		this.start=new FallingParticle(Color.RED, x, y);
		
		this.p1=new ParticleWithPosition(Color.RED, 0, 0);
		this.p2=new ParticleWithPosition(Color.RED, 0, 0);
		this.p3=new ParticleWithPosition(Color.RED, 0, 0);
		update();
		
		
		
		this.p1.setLinksVon(this.start);
		this.p2.setUnter(this.start);
		this.p3.setRechtsVon(this.p2);
		
		
		particles.add(start);
		particles.add(p1);
		particles.add(p2);
		particles.add(p3);
		
		getBlockMatrix().add(new int[][]{
            {0, 0, 0, 0},
            {7, 7, 0, 0},
            {0, 7, 7, 0},
            {0, 0, 0, 0}
    });
		getBlockMatrix().add(new int[][]{
            {0, 7, 0, 0},
            {7, 7, 0, 0},
            {7, 0, 0, 0},
            {0, 0, 0, 0}
    });
	}

	public ArrayList<Particle> getParticles() {
		return particles;
	}
	
	public void updateParticles() {
		start.update();
		p1.update();
		p2.update();
		p3.update();
		
	}

	public void setParticles(ArrayList<Particle> particles) {
		this.particles = particles;
	}

	public FallingParticle getStart() {
		return start;
	}

	public List<Rectangle> getRectangles() {
		
		return Arrays.asList(start.getR(),p1.getR(),p2.getR(),p3.getR());
	}


		
}
