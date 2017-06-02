package com.tetris.logic.blocks;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.shape.Rectangle;

public abstract class Block {
	
	protected ArrayList<ParticleWithPosition> particles;
	public static int objects;
	public int number;
	 private final List<int[][]> blockMatrix = new ArrayList<>();
	 private List<ParticleWithPosition> existierendenPartikel;
	 
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
	
	abstract FallingParticle getStart();
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

}
