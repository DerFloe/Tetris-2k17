/**
 * 
 */
package com.spg.game;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @author florianhofer
 *
 */
public class Tetris2k17 extends Application{

	/**
	 * 
	 */
	private double timer;
	private boolean musicOn=true;
	public static final int GATE_WIDTH=15;
	public static final int GATE_HEIGHT=20;
	public static final int BOX_SIZE=40;
	private GraphicsContext gC;
	private int[][] gate = new int[GATE_WIDTH][GATE_HEIGHT];
	private Block current;
	private List<Block> defaultBlocks=new ArrayList<>();
	private List<Block> blocks=new ArrayList<>();
	public Tetris2k17() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	
	  public void prerender() {
	        gC.clearRect(0, 0, GATE_WIDTH * BOX_SIZE, GATE_HEIGHT * BOX_SIZE);

	    blocks.forEach(b -> b.draw(gC));
	  }
	  
	  public void placeParticle(Particle block) {
	        gate[block.getX()][block.getX()]++;
	  }
	  
	  public void removeParticle(Particle block){
		  gate[block.getX()][block.getY()]--;
	  }
	  
	  public boolean notOnScreen(Particle b){
		  return b.getX()<0 || b.getX()>=GATE_WIDTH
				|| b.getY()< 0|| b.getY()>=GATE_HEIGHT;  
	  }
	private Parent summonItems(){
		Media m = new Media(Paths.get("soundtrackremix.mp3").toUri().toString());
		MediaPlayer mPlayer=new MediaPlayer(m);
		mPlayer.play();
		
		Pane root = new Pane();
		
		root.setPrefSize(GATE_WIDTH * BOX_SIZE, GATE_HEIGHT * BOX_SIZE);
		Canvas canvas = new Canvas(GATE_WIDTH * BOX_SIZE, GATE_HEIGHT * BOX_SIZE);
		gC=canvas.getGraphicsContext2D();
		root.getChildren().addAll(canvas);
		Button muteB=new Button("Mute");
		muteB.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				if(musicOn==true){
					musicOn=false;
					mPlayer.stop();
				
				}else{
					musicOn=true;
					mPlayer.play();
				}
			}
			
		});
		root.getChildren().add(muteB);
		
		//SIDENOTE: ADD ALL DIFFERENT TYPES OF BLOCKS
		defaultBlocks.add(new Block(Color.RED,
				new Particle(0, Position.UNDER),
                new Particle(3, Position.RIGHT),
                new Particle(2, Position.RIGHT),
                new Particle(1, Position.UNDER)));
		
		defaultBlocks.add(new Block(Color.BLUE,
				new Particle(0, Position.UNDER),
                new Particle(1, Position.RIGHT),
                new Particle(2, Position.RIGHT),
                new Particle(1, Position.UNDER)));
		spawn();
		AnimationTimer t = new AnimationTimer() {
            @Override
            public void handle(long now) {
                timer += 0.020;

                if (timer >= 0.5) {
                    refresh();
                    prerender();
                    timer = 0;
                }
            }
        };
        t.start();

        return root;
		}
	


	public void refresh(){
		makeMove(p -> p.move(Position.UNDER), p -> p.move(Position.ABOVE), true);
	}
	
	private void makeMove(Consumer<Block> onSuccess, Consumer<Block> onFail, boolean endMove) {
        current.particles.forEach(this::removeParticle);

        onSuccess.accept(current);

        boolean offscreen = current.particles.stream().anyMatch(this::notOnScreen);

        if (!offscreen) {
            current.particles.forEach(this::placeParticle);
        } else {
            onFail.accept(current);

            current.particles.forEach(this::placeParticle);

            if (endMove) {
                sweep();
            }

            return;
        }

        if (!isTrue()) {
            current.particles.forEach(this::removeParticle);

            onFail.accept(current);

            current.particles.forEach(this::placeParticle);

            if (endMove) {
                sweep();
            }
        }
    }
	
	  private List<Integer> sweepRows() {
	        List<Integer> rows = new ArrayList<>();

	        outer:
	        for (int y = 0; y < GATE_HEIGHT; y++) {
	            for (int x = 0; x < GATE_WIDTH; x++) {
	                if (gate[x][y] != 1) {
	                    continue outer;
	                }
	            }

	            rows.add(y);
	        }

	        return rows;
	    }

	
	private void sweep(){
		 List<Integer> rows = sweepRows();
	        rows.forEach(row -> {
	            for (int x = 0; x < GATE_WIDTH; x++) {
	                for (Block block : blocks) {
	                    block.undock(x, row);
	                }

	                gate[x][row]--;
	            }
	        });

	        rows.forEach(row -> {
	            blocks.stream().forEach(b -> {
	                b.particles.stream()
	                        .filter(p -> p.getY() < row)
	                        .forEach(particle -> {
	                            removeParticle(particle);
	                            particle.setY(particle.getY()+1);
	                            placeParticle(particle);
	                        });
	            });
	        });

	        spawn();
	    }
	
	
	private void spawn() {
        Block block = defaultBlocks.get(new Random().nextInt(defaultBlocks.size())).duplicate();
        block.move(GATE_WIDTH / 2, 0);

        current = block;

        blocks.add(block);
        block.particles.forEach(this::placeParticle);

//        if (!isTrue()) {
//            System.out.println("Game Over");
//            System.exit(0);
//        }
    }
	
	private boolean isTrue() {
        for (int y = 0; y < GATE_HEIGHT; y++) {
            for (int x = 0; x < GATE_WIDTH; x++) {
                if (gate[x][y] > 1) {
                    return false;
                }
            }
        }

        return true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		   Scene scene = new Scene(summonItems());
		  
	        scene.setOnKeyPressed(e -> {
	        	Media me = new Media(Paths.get("tick.mp3").toUri().toString());
	    		MediaPlayer mePlayer=new MediaPlayer(me);
	    		mePlayer.play();
	            if (e.getCode() == KeyCode.SPACE) {
	                makeMove(p -> p.turn(), p -> p.turnReverse(), false);
	            } else if (e.getCode() == KeyCode.LEFT) {
	                makeMove(p -> p.move(Position.LEFT), p -> p.move(Position.RIGHT), false);
	            } else if (e.getCode() == KeyCode.RIGHT) {
	                makeMove(p -> p.move(Position.RIGHT), p -> p.move(Position.LEFT), false);
	            } else if (e.getCode() == KeyCode.DOWN) {
	                makeMove(p -> p.move(Position.UNDER), p -> p.move(Position.ABOVE), true);
	            }

	            prerender();
	        });

	        primaryStage.setTitle("Tetris 2k17");
	        primaryStage.setScene(scene);
	        primaryStage.show();

	}
	
	

}
