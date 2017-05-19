/**
 * 
 */
package com.tetris.game;

import com.tetris.logic.blocks.Particle;

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
	
	public Particle[][] fields;
	private int xAxe;
	private int yAxe;
	
	public CommandsXGamefield(int xAxe, int yAxe) {
		
		
		this.xAxe = xAxe;
		this.yAxe = yAxe;
		this.fields = new Particle[yAxe][xAxe];
	}
	
	public CommandsXGamefield(){
		this(10,20);
	}


	
	
	public Pane generateGamefield(){
			Main m=new Main(10,20);
			
			Pane pane = new Pane();
			
			
			int gapy=0;
		    for(int i=0;i<=yAxe-1;i++){
		    	int gapx=20;
		    	
		    	for(int o=0;o<=xAxe-1;o++){
		    		
		    		
		    		m.fields[i][o]=new Particle(Color.WHITE);
		    		m.fields[i][o].setR(new Rectangle(gapx,gapy,20,20));
		    		m.fields[i][o].getR().setStroke(Color.GRAY);
		    		
		    		m.fields[i][o].getR().setFill(m.fields[i][o].getColor());
		    	
//		    		field[gapx][gapy]=p;
		    		int indexNr=i+o;
//		    		System.out.println("Gamefield particle: ["+i+"/"+o+"] summoned index: "+m.fields[i][o].getNum());
		    		
		    		pane.getChildren().add(m.fields[i][o].getR());
		    	
//		    		System.out.println("Gamefield particle : ["+i+"/"+o+"] added to Array");
		    		System.out.print("O");
		    		gapx+=20;
		    		
		    	}
		    	System.out.println("");
		    	gapy+=20;
//		    	root.getChildren().addAll(field);
		    	
		    
	    	
		    }
		    
		
		   
		//    m.summonBlock(1, 1, Color.BLACK, root);
			
			return pane;
			
		
	}

}
