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
		if(y >= 0f) {
		y-= 0.05f;
		updateRectangle();
		}
	}
	
	
	
	public void moveLeft(){
		if(x>0){
			x--;
		}
		
	}
	
	public void moveRight(){
		if(x<9){
		x++;
		}
	}
	

}
