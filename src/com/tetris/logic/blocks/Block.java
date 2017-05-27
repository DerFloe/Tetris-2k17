package com.tetris.logic.blocks;

import java.util.ArrayList;
import java.util.List;

public abstract class Block {
	
	public static int objects;
	public int number;
	 private final List<int[][]> blockMatrix = new ArrayList<>();
	public Block() {
		// TODO Auto-generated constructor stub
		objects++;
		number = objects;
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
	
	
	

}
