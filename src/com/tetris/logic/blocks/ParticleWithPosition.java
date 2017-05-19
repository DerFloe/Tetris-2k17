package com.tetris.logic.blocks;

import javafx.scene.paint.Color;

public class ParticleWithPosition extends Particle {

	protected ParticleWithPosition rechtsVon;
	protected ParticleWithPosition linksVon;
	protected ParticleWithPosition unter;
	protected ParticleWithPosition ueber;
	protected int x;
	protected float y;
	
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
		if(rechtsVon !=null){
			x=rechtsVon.x+1;
			y=rechtsVon.y;

		}
		
		if(linksVon!=null){
			x=linksVon.x-1;
			y=linksVon.y;
		}
		if(unter!=null){
			x=unter.x;
			y=unter.y-1;
		}
		if(ueber!=null){
			x=ueber.x;
			y=ueber.y+1;
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
	
	
}
