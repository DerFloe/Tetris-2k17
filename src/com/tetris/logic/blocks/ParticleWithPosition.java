package com.tetris.logic.blocks;

import javafx.scene.paint.Color;

public class ParticleWithPosition extends Particle {

	protected int x;
	protected int y;
	
	public ParticleWithPosition(int x, int y) {
		this(Color.TRANSPARENT, x, y);
	}

	public ParticleWithPosition(Color color, int x, int y) {
		super(color);
		
		this.x = x;
		this.y = y;
		
		updateRectangle();
	}

	public void updateRectangle() {
		r.setX(x);
		r.setY(y);
	}
}
