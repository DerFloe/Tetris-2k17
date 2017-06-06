package com.tetris.logic.blocks;

import java.util.List;

import javafx.scene.paint.Color;

public class FallingParticle extends ParticleWithPosition {

	
	public int bottom;
	public FallingParticle(int x, int y) {
		super(x, y);
		
		bottom=0;
	}

	public FallingParticle(Color color, int x, int y) {
		super(color, x, y);
		
		bottom=0;
	}
	public void update(List<ParticleWithPosition> existierendenPartikel) {
	if(groundReached(existierendenPartikel)==false) {
		System.out.println("Hallo");
	y-= 0.05f;
	}else{
		y=0;
	}
	updateRectangle();
}
	
	public boolean groundReached(List<ParticleWithPosition> existierendenPartikel){
	if(y<=0||istKollidiert(existierendenPartikel)){
		return true;
	}
	return false;
}
	
	public void moveLeft(){
	if(x>0&&y > 0){
		x--;
	}
	
}
	
	public void moveRight(){
	if(x<9&&y > 0){
	x++;
	}
}
	
	
// 	Methods with bottom
//	public void update() {
//		if(y > bottom) {
//		y-= 0.05f;
//		System.out.println(bottom);
//		}else{
//			y=bottom;
//		}
//		updateRectangle();
//	}
//	
//	public boolean groundReached(){
//		if(y<=bottom){
//			return true;
//		}
//		return false;
//	}
//	
//	
//	public void moveLeft(){
//		if(x>0&&y > bottom){
//			x--;
//		}
//		
//	}
//	
//	public void moveRight(){
//		if(x<9&&y > bottom){
//		x++;
//		}
//	}

	public int getBottom() {
		return bottom;
	}

	public void setBottom(int bottom) {
		this.bottom = bottom;
	}

	

}
