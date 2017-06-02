package com.tetris.game;
	
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.tetris.logic.blocks.Block;
import com.tetris.logic.blocks.FallingParticle;
import com.tetris.logic.blocks.IBlock;
import com.tetris.logic.blocks.JBlock;
import com.tetris.logic.blocks.LBlock;
import com.tetris.logic.blocks.OBlock;
import com.tetris.logic.blocks.Particle;
import com.tetris.logic.blocks.ParticleWithPosition;
import com.tetris.logic.blocks.SBlock;
import com.tetris.logic.blocks.TBlock;
import com.tetris.logic.blocks.ZBlock;

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


public class GameStarter extends Application {
	public Particle[][] fields;
	private int xAxe;
	private int yAxe;
	private Pane gameField;
	private Scene scene;
	private CommandsXGamefield m;
	private Stage primaryStage;
	private int startX;
	private int startY;
	private BorderPane root;
	private int bottom;
	
	private Block current;
	private ArrayList<Block> blocksRand;
	
	private List<ParticleWithPosition> existierendenPartikel = new ArrayList<>();
	
	public GameStarter(int xAxe, int yAxe) {
		super();
		this.bottom=-1;
		this.xAxe = xAxe;
		this.yAxe = yAxe;
		this.fields = new Particle[yAxe][xAxe];
		this.primaryStage=new Stage();
		blocksRand=new ArrayList<>();
		this.startX=3;
		this.startY=20;
		blocksRand.add(new IBlock(startX,startY,existierendenPartikel));
		blocksRand.add(new JBlock(startX,startY,existierendenPartikel));
		blocksRand.add(new LBlock(startX,startY,existierendenPartikel));
		blocksRand.add(new OBlock(startX,startY,existierendenPartikel));
		blocksRand.add(new SBlock(startX,startY,existierendenPartikel));
		blocksRand.add(new TBlock(startX,startY,existierendenPartikel));
		blocksRand.add(new ZBlock(startX,startY,existierendenPartikel));
		
	}
	
	public GameStarter(){
		this(10,20);
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			
			this.primaryStage=primaryStage;
			root = new BorderPane();
			
			this.scene = new Scene(root,200,410);
			
			this.m=new CommandsXGamefield(12,21);
			gameField = m.generateGamefield();
			root.setCenter(gameField);
			generateBorder();
			//FOR CSS
			root.setId("pane");
			this.scene.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
			
		
			this.primaryStage.setScene(this.scene);
			//fill();
			this.primaryStage.show();
//			m.refresh(this.primaryStage);
			
			
			
			scene.setOnKeyPressed(k -> {
				if(k.getCode() == KeyCode.LEFT) {
					
					
					
					if(current instanceof IBlock){
						((IBlock)current).getStart().moveLeft();
					}
					if(current instanceof JBlock){
						((JBlock)current).getStart().moveLeft();
					}
					if(current instanceof LBlock){
						((LBlock)current).getStart().moveLeft();
					}
					if(current instanceof OBlock){
						((OBlock)current).getStart().moveLeft();
					}
					if(current instanceof SBlock){
						((SBlock)current).getStart().moveLeft();
					}
					if(current instanceof TBlock){
						((TBlock)current).getStart().moveLeft();
					}
					
					if(current instanceof ZBlock){
						((ZBlock)current).getStart().moveLeft();
					}
					System.out.println("LEFT");
				}
				if(k.getCode()== KeyCode.RIGHT){
					
					current.moveRight();
					
					System.out.println(("RIGHT"));
				}
				if(k.getCode()== KeyCode.UP){
					current.rotateRight();
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
			
			current = randomBlock(); // summonBlock(3, Color.RED, gameField);
			drawBlock();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// das wird 30x in der ausgefuehrt
	public void update() {
		try{
		if(current != null)  {
			
			// summonBlock(3, Color.RED, gameField);
			if(current instanceof IBlock){
				((IBlock)current).update();
			}
			if(current instanceof JBlock){
				((JBlock)current).update();
			}
			if(current instanceof LBlock){
				((LBlock)current).update();
			}
			if(current instanceof OBlock){
				((OBlock)current).update();
			}
			if(current instanceof SBlock){
				((SBlock)current).update();
			}
			if(current instanceof TBlock){
				((TBlock)current).update();
			}
			
			if(current instanceof ZBlock){
				((ZBlock)current).update();
			}
		}
		if(current instanceof IBlock){
			if(((IBlock)current).getStart().groundReached(existierendenPartikel)||((IBlock)current).getStart().istKollidiert(existierendenPartikel)){
				root.getChildren().removeAll(current.getRectangles());
				currentToBg(current);
				current=randomBlock();
				drawBlock();
				System.out.println("IBLOCK Reached Ground");
			}
		}
		if(current instanceof JBlock){
			if(((JBlock)current).getStart().groundReached(existierendenPartikel)){
				current=randomBlock();
				drawBlock();
				System.out.println("JBLOCK Reached Ground");
			}
		}
		if(current instanceof LBlock){
			if(((LBlock)current).getStart().groundReached(existierendenPartikel)){
				current=randomBlock();
				drawBlock();
				System.out.println("LBLOCK Reached Ground");
			}
		}
		if(current instanceof OBlock){
			if(((OBlock)current).getStart().groundReached(existierendenPartikel)){
				current=randomBlock();
				drawBlock();
				System.out.println("OBLOCK Reached Ground");
			}
		}
		if(current instanceof SBlock){
			if(((SBlock)current).getStart().groundReached(existierendenPartikel)){
				current=randomBlock();
				System.out.println("SBLOCK Reached Ground");
			}
		}
		if(current instanceof TBlock){
			if(((TBlock)current).getStart().groundReached(existierendenPartikel)){
				current=randomBlock();
				drawBlock();
				System.out.println("TBLOCK Reached Ground");
			}
		}
		
		if(current instanceof ZBlock){
			if(((ZBlock)current).getStart().groundReached(existierendenPartikel)){
				current=randomBlock();
				drawBlock();
				System.out.println("ZBLOCK Reached Ground");
			}
		}
		}
		catch(Exception e){
			e.printStackTrace();
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
	 * pics random block from array HINT: HIER MUSS FÜR EINE VARIABLE GRÖ?E DES SPIELFELDES EINE VARIABLE VERWENDET WERDEN
	 * @return
	 */
	public Block randomBlock(){
		if(bottom<=20){
		bottom++;
		Random r=new Random();
		int index=r.nextInt(6);
		
		if(blocksRand.get(index) instanceof IBlock){
			 IBlock b = new IBlock(startX,startY, existierendenPartikel);
			 b.getStart().setBottom(bottom);
			 return b;
		}
		if(blocksRand.get(index) instanceof JBlock){
			JBlock b = new JBlock(startX,startY, existierendenPartikel);
			 b.getStart().setBottom(bottom);
			 return b;
		}
		if(blocksRand.get(index) instanceof LBlock){
			LBlock b = new LBlock(startX,startY,existierendenPartikel);
			 b.getStart().setBottom(bottom);
			 return b;
		}
		if(blocksRand.get(index) instanceof OBlock){
			OBlock b = new OBlock(startX,startY,existierendenPartikel);
			 b.getStart().setBottom(bottom);
			 return b;
		}
		if(blocksRand.get(index) instanceof SBlock){
			SBlock b = new SBlock(startX,startY,existierendenPartikel);
			 b.getStart().setBottom(bottom);
			 return b;
		}
		if(blocksRand.get(index) instanceof TBlock){
			TBlock b = new TBlock(startX,startY,existierendenPartikel);
			 b.getStart().setBottom(bottom);
			 return b;
		}
		if(blocksRand.get(index) instanceof ZBlock){
			ZBlock b = new ZBlock(startX,startY,existierendenPartikel);
			 b.getStart().setBottom(bottom);
			 return b;
		}
		return blocksRand.get(index);
		}
		return null;
		
		
	}
	
	/**
	 * loop till y from block reaches ground
	 * loop executes moveBlockDown method
	 */
	public void fall(int x, int y){
		
	}
	
	public void drawBlock(){
		if(current instanceof IBlock){
			root.getChildren().addAll(((IBlock)current).getRectangles());
		}
		if(current instanceof JBlock){
			root.getChildren().addAll(((JBlock)current).getRectangles());
		}
		if(current instanceof LBlock){
			root.getChildren().addAll(((LBlock)current).getRectangles());
		}
		if(current instanceof OBlock){
			root.getChildren().addAll(((OBlock)current).getRectangles());
		}
		if(current instanceof SBlock){
			root.getChildren().addAll(((SBlock)current).getRectangles());
		}
		if(current instanceof TBlock){
			root.getChildren().addAll(((TBlock)current).getRectangles());
		}
		
		if(current instanceof ZBlock){
			root.getChildren().addAll(((ZBlock)current).getRectangles());
		}
	}
	
	
	public Particle[][] getFields() {
		return fields;
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	
	public void generateBorder(){
		for(int i=1;i<=21;i++){
			
		}
	}
	
	//setzt die partikel von uebergebenm parameter auf eine arraylist und gibt sie wieder in die scene
	public void currentToBg(Block b){
		for(Rectangle r: b.getRectangles()){
			root.getChildren().add(r);
			existierendenPartikel.add(b.getStart());
			
		}
	}
}
