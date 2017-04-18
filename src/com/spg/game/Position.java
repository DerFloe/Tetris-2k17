package com.spg.game;

public enum Position {
	ABOVE(0,-1),
	RIGHT(1,0),
	UNDER(0,1),
	LEFT(-1,0);
	
	private int x;
	private int y;
	// enum is better, to clarify on which position every block is, outgoing from the middle block
	
	//EXAMPLE (3 Block is always the axis)
	//L Block
	//1
	//234
	
	Position(int x,int y){
		this.x=x;
		this.y=y;
	}
}
