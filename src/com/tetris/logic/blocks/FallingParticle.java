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
		y++;
		updateRectangle();
	}
}
