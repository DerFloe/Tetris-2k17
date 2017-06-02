package com.tetris.logic.blocks;

import java.util.List;

import javafx.scene.paint.Color;

public class ParticleWithPosition extends Particle {

	protected ParticleWithPosition rechtsVon;
	protected ParticleWithPosition linksVon;
	protected ParticleWithPosition unter;
	protected ParticleWithPosition ueber;
	protected int x;
	protected float y;
	protected int rotation;
	
	public int getRotation() {
		return rotation;
	}

	public void setRotation(int rotation) {
		this.rotation = rotation;
	}

	public ParticleWithPosition(int x, int y) {
		this(Color.TRANSPARENT, x, y);
	}

	public ParticleWithPosition(Color color){
		this(color,0, 0);
	}
	public ParticleWithPosition(Color color, int x, int y) {
		super(color);
		
		this.x = x;
		this.y = y;
		
		updateRectangle();
	}

	public void updateRectangle() {
		r.setX(x * 20.);
		r.setY(y * 20.*-1+390);
	}
	
	public void update() {
		int h=0;
		ParticleWithPosition ref = null;
		if(rechtsVon !=null){
			h = 1;
			ref = rechtsVon;
		}
		
		if(linksVon!=null){
			h=-1;
			ref=linksVon;
		}
		if(unter!=null ){
			h=2;
			ref=unter;
		}
		if(ueber!=null){
			h=0;
			ref=ueber;
		}
		
		if(ref != null) {
			
		
		
		h += rotation;
		h = Math.floorMod(h, 4);
		
		//rechtsVon
		if(h==1) {
			x=ref.x+1;
			y=ref.y;
		}
		//linksVon
		if(h==3){
			x=ref.x-1;
			y=ref.y;
		}
		//unter
		if(h==2){
			x=ref.x;
			y=ref.y-1;
		}
		//ueber
		if(h==0){
			x=ref.x;
			y=ref.y+1;
		}
		}
		updateRectangle();
	}

	public ParticleWithPosition getRechtsVon() {
		return rechtsVon;
	}

	public void setRechtsVon(ParticleWithPosition rechtsVon) {
		this.rechtsVon = rechtsVon;
	}

	public ParticleWithPosition getLinksVon() {
		return linksVon;
	}

	public void setLinksVon(ParticleWithPosition linksVon) {
		this.linksVon = linksVon;
	}

	public ParticleWithPosition getUnter() {
		return unter;
	}

	public void setUnter(ParticleWithPosition unter) {
		this.unter = unter;
	}

	public ParticleWithPosition getUeber() {
		return ueber;
	}

	public void setUeber(ParticleWithPosition ueber) {
		this.ueber = ueber;
	}

	public void rotateRight() {
		// TODO Auto-generated method stub
		rotation+=1;
	}
	
	public boolean istKollidiert(List<ParticleWithPosition> existierendenPartikel){
		int ceil=(int)Math.ceil(y);
		int floor=(int)Math.floor(y);
		for(ParticleWithPosition exp : existierendenPartikel){
			if(exp.getX()==getX()&&exp.getY()==ceil||exp.getY()==floor){
				return true;
			}
		}
		return false;
		
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	
	
}
