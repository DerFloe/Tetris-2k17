/**
 * 
 */
package com.tetris.logic.assets;

/**
 * @author florianhofer
 *
 */
public class Score {

	/**
	 * 
	 */
	private Integer score;
	public Score() {
		// TODO Auto-generated constructor stub
		this.score=0;
	}
	
	public void add(Integer i){
		score+=i;
	}
	
	public void reset(){
		score=0;
	}

	public Integer getScore() {
		return score;
	}
	
	

}
