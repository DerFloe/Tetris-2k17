package com.tetris.logic.blocks;

import java.util.ArrayList;
import java.util.List;

public abstract class Block {

	 private final List<int[][]> blockMatrix = new ArrayList<>();
	public Block() {
		// TODO Auto-generated constructor stub
	}
	public List<int[][]> getBlockMatrix() {
		return blockMatrix;
	}
	
	

}
