/**
 * 
 */
package com.tetris.game;

import com.tetris.logic.blocks.Particle;
import com.tetris.logic.blocks.ParticleWithPosition;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * @author florianhofer
 *
 */
public class CommandsXGamefield {

	/**
	 * 
	 */
	
	public ParticleWithPosition[][] fields;
	private int xAxe;
	private int yAxe;
	
	public CommandsXGamefield(int xAxe, int yAxe) {
		
		
		this.xAxe = xAxe;
		this.yAxe = yAxe;
		this.fields = new ParticleWithPosition[yAxe][xAxe];
	}
	
	public CommandsXGamefield(){
		this(10,20);
	}


	
	
	public Pane generateGamefield(){
			GameStarter m=new GameStarter(10,20);
			
			Pane pane = new Pane();
			
			
			int gapy=0;
		    for(int y=0;y<=yAxe-1;y++){
		    	
		    	for(int x=0;x<=xAxe-1;x++){
		    		
		    		
		    		m.fields[y][x]=new ParticleWithPosition(Color.WHITE, x, y);
		    		
		    		
		    		
//		    		field[gapx][gapy]=p;
		    		int indexNr=y+x;
//		    		System.out.println("Gamefield particle: ["+i+"/"+o+"] summoned index: "+m.fields[i][o].getNum());
		    		
		    		pane.getChildren().add(m.fields[y][x].getR());
		    	
//		    		System.out.println("Gamefield particle : ["+i+"/"+o+"] added to Array");
		    		System.out.print("O");
		    		
		    	}
		    	System.out.println("");
		    
//		    	root.getChildren().addAll(field);
		    	
		    
	    	
		    }
		    
		
		   
		//    m.summonBlock(1, 1, Color.BLACK, root);
			
			return pane;
			
		
	}

}
