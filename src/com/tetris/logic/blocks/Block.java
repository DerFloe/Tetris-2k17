package com.tetris.logic.blocks;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.shape.Rectangle;

public abstract class Block {
	
	protected ArrayList<ParticleWithPosition> particles;
	protected FallingParticle start;
	protected ParticleWithPosition p1;
	protected ParticleWithPosition p2;
	protected ParticleWithPosition p3;
	public static int objects;
	public int number;
	 private final List<int[][]> blockMatrix = new ArrayList<>();
	 protected List<ParticleWithPosition> existierendenPartikel;
	 
	 private int linksRechtsWunsch = 0; // 0 kein Wunsch, -1 heisst links, 1 heisst rechts
	public Block(List<ParticleWithPosition> existierendenPartikel) {
		// TODO Auto-generated constructor stub
		objects++;
		number = objects;
		this.existierendenPartikel = existierendenPartikel;
	}
	public List<int[][]> getBlockMatrix() {
		return blockMatrix;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + number;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Block other = (Block) obj;
		if (number != other.number)
			return false;
		return true;
	}
	public void rotateRight() {
		for (ParticleWithPosition p : particles) {
			p.rotateRight();
		}
	}
	
	public List<Rectangle> getRectangles(){
		List<Rectangle> rectanglesToReturn=new ArrayList<>();
		for (ParticleWithPosition p : particles) {
			rectanglesToReturn.add(p.getR());
		}
		return rectanglesToReturn;
	}
	public void moveRight() {
		linksRechtsWunsch=1;
		
	}
	
	public abstract FallingParticle getStart();
	public void update() {
		if(linksRechtsWunsch == 1) {
			getStart().moveRight();
			linksRechtsWunsch = 0;

			// position updaten
			updateParticles();
			
			if(istKollidiert()) {
				getStart().moveLeft();
			}
		}
		updateParticles();
	}
	
	private boolean istKollidiert() {
		for(ParticleWithPosition p:particles){
			return p.istKollidiert(existierendenPartikel);
		}
		return false;
	}
	abstract void updateParticles();
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
	public void setStart(FallingParticle start) {
		this.start = start;
	}
	

}
