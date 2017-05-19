package com.tetris.game;
	
import com.tetris.logic.blocks.FallingParticle;
import com.tetris.logic.blocks.Particle;
import com.tetris.logic.blocks.ParticleWithPosition;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Main extends Application {
	public Particle[][] fields;
	private int xAxe;
	private int yAxe;
	private Pane gameField;
	private Scene scene;
	private CommandsXGamefield m;
	private Stage primaryStage;
	
	private FallingParticle current;
	
	public Main(int xAxe, int yAxe) {
		super();
		
		this.xAxe = xAxe;
		this.yAxe = yAxe;
		this.fields = new Particle[yAxe][xAxe];
		this.primaryStage=new Stage();
		
	}
	
	public Main(){
		this(10,20);
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			
			this.primaryStage=primaryStage;
			BorderPane root = new BorderPane();
			
			this.scene = new Scene(root,400,400);
			
			this.m=new CommandsXGamefield(10,20);
			gameField = m.generateGamefield();
			root.setCenter(gameField);
			
			//FOR CSS
			root.setId("pane");
			this.scene.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
			
		
			this.primaryStage.setScene(this.scene);
			//fill();
			this.primaryStage.show();
//			m.refresh(this.primaryStage);
			
			
			
			scene.setOnKeyPressed(k -> {
				if(k.getCode() == KeyCode.LEFT) {
					current.moveLeft();
					System.out.println("LEFT");
				}
				if(k.getCode()== KeyCode.RIGHT){
					current.moveRight();
					System.out.println(("RIGHT"));
				}
			});
			
			// fixe rate um logik zu simulieren: 30/secs
			
			long nanosInterval = 1000000000l / 30l;
			
			
			new AnimationTimer() {
				private long nextUpdate = System.nanoTime();
				
				@Override
				public void handle(long now) {
					if(now >= nextUpdate) {
						update();
						nextUpdate += nanosInterval;
					}
				}
			}.start();
			
			current = summonBlock(3, Color.RED, gameField);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// das wird 30x in der ausgefuehrt
	public void update() {
		if(current != null)  {
			current.update();
		}
	}
	
	public FallingParticle summonBlock(int x, Color c, Pane root){
		
		FallingParticle r=new FallingParticle(c, x, 20);
		root.getChildren().add(r.getR());
		
//		this.fields[x][y].setR(new Rectangle(20*x,20*y,20,20));
		System.out.println("Block added at: ["+x+"/20]");
	
		return r;
	}
	
	public void fallBlock(int x,int y, Pane root) throws InterruptedException{
		for(int i=0;i<yAxe;i++){
			
			Rectangle backup=this.fields[x][y].getR();
			
//			Rectangle old=this.fields[x][y].getR();
//			old.setFill(Color.WHITE);
//			old.setStroke(Color.BLACK);
//			this.fields[x][y].setR(old);
			
			this.fields[x][y].getR().setFill(Color.WHITE);
			this.fields[x][y].getR().setStroke(Color.BLACK);
			
			
			//Hier muss dann das weiße rechteck eingesetzt werden , darunter kommt das neue
			
//		Thread.sleep(1000);
			
			Rectangle newRec = new Rectangle(y+(i*20),x,20,20);
			newRec.setFill(Color.BLACK);
			backup.setTranslateY(y+(i*20));
			root.getChildren().add(newRec);
			
			
			
		}
	}
	
	public void fill(){
		int gapy=0;
		System.out.println("Tetris: Filling Array");
		for(int i=0;i<=yAxe-1;i++){
	    	int gapx=20;
	    	
	    	for(int o=0;o<=xAxe-1;o++){
	    		
	    		
	    		this.fields[i][o]=new Particle(Color.WHITE);
//	    		field[gapx][gapy]=p;
	    		
	    		
	    		this.gameField.getChildren().add(this.fields[i][o].getR());
	    	
	    		
	    		gapx+=20;
	    		
	    	}
	    	gapy+=20;
//	    	root.getChildren().addAll(field);
	    	
	    	System.out.println("Tetris: Done");
    	
	    }
	}
	
	public void refresh(Stage istage){
		
		System.out.println("Tetris: Refresh command executed");
		this.scene = new Scene(gameField,400,400);
		istage.setScene(scene);
		
		int gapy=0;
		int counter=0;
	    for(int i=0;i<=yAxe-1;i++){
	    	int gapx=20;
	    	
	    	for(int o=0;o<=xAxe-1;o++){
	    		
	    		
//	    		this.fields[i][o]=new Particle(Color.WHITE);
//	    		this.fields[i][o].setR(new Rectangle(gapx,gapy,20,20));
//	    		this.fields[i][o].getR().setStroke(Color.GRAY);
//	    		
//	    		this.fields[i][o].getR().setFill(Color.RED);
	    		
	    		
//	    		field[gapx][gapy]=p;
//	    		int indexNr=i+o;
	    		
	    		
	    		this.gameField.getChildren().add(this.fields[i][o].getR());
	    	
	    		
	    		gapx+=20;
	    		counter++;
	    		
	    	}
	    	gapy+=20;
//	    	root.getChildren().addAll(field);
	    	
	    
    	
	    }
	    System.out.println("Refresh done");
	   
	    
	    
	}
	
	/**
	 * puts block to coordinate y-1
	 * x y coordinates in grid
	 */
	public void moveBlockDown(int x, int y){
		
	}
	
	/**
	 * loop till y from block reaches ground
	 * loop executes moveBlockDown method
	 */
	public void fall(int x, int y){
		
	}
	
	
	
	
	public Particle[][] getFields() {
		return fields;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
