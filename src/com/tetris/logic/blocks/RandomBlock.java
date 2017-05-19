/**
 * 
 */
package com.tetris.logic.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author florianhofer
 *
 */
public class RandomBlock {

	/**
	 * 
	 */
	private List<Block> liste;
	public RandomBlock() {
		// TODO Auto-generated constructor stub
		liste = new ArrayList<>();
        liste.add(new IBlock());
        liste.add(new JBlock());
        liste.add(new LBlock());
        liste.add(new OBlock());
        liste.add(new SBlock());
        liste.add(new TBlock());
     //   liste.add(new ZBlock());
	}
	
	public Block getRandomBlock(){
		Random rand = new Random();

		int  n = rand.nextInt(7);
		return liste.get(n);
		//50 is the maximum and the 1 is our minimum 
	}

}
