package com.tetris.logic.blocks;

import javafx.scene.paint.Color;

public class FallingParticle extends ParticleWithPosition {

	public FallingParticle(int x, int y) {
		super(x, y);
		}

	public FallingParticle(Color color, int x, int y) {
		super(color, x, y);
	}

	public void update() {
		if(y > 0f) {
		y-= 0.05f;
		
		}else{
			y=0;
		}
		updateRectangle();
	}
	
	public boolean groundReached(){
		if(y<=0f){
			return true;
		}
		return false;
	}
	
	
	public void moveLeft(){
		if(x>0&&y > 0f){
			x--;
		}
		
	}
	
	public void moveRight(){
		if(x<9&&y > 0f){
		x++;
		}
	}
	

}
