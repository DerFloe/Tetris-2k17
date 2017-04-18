package com.spg.game;

public class Particle {

	
	private Position position;
	private int x;
	private int y;
	private int distance;
	private Block block;
	
	//distance, how much cells away from the middle block 
	//position, is necessary to define in which direction the block is
	private Particle(int distance, Position position) {
		// TODO Auto-generated constructor stub
		this.distance=distance;
		this.position=position;
	}
	
	public Particle duplicate(){
		return new Particle(distance, position);
	}

	
	public void setBlock(Block block){
		this.block=block;
		x=block.getX()+distance*position.getX();
		y=block.getY()+distance*position.getY();
	}
	
	
}
