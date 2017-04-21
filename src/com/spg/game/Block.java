package com.spg.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import static com.spg.game.Tetris2k17.BOX_SIZE;

public class Block {
	
	private Color color;
	List<Particle> particles;
	private int x;
	private int y;
	
	public Block(Color color, Particle ...particles){
		
		this.particles=new ArrayList<>(Arrays.asList(particles));
		this.color=color;
		
		for(Particle p:particles){
			p.setBlock(this);
		}
		
	}
	
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public void draw(GraphicsContext g){
		g.setFill(color);
		particles.forEach(p -> g.fillRect(p.getX()*BOX_SIZE, p.getY()*BOX_SIZE, BOX_SIZE, BOX_SIZE));
	}
	
	public void move(int moveX,int moveY){
		x=x+moveX;
		y=y+moveY;
		particles.forEach(p -> {
			p.setX(p.getX()+moveX);
			p.setY(p.getY()+moveY);
		});
	}
	 public void move(Position p) {
	        move(p.getX(), p.getY());
	    }
	public void undock(int x, int y){
		particles.removeIf(p -> p.getX() == x && p.getY()==y);
	}
	
	public Block duplicate(){
		return new Block(color, particles.stream()
				.map(Particle::duplicate)
				.collect(Collectors.toList())
				.toArray(new Particle[0]));
	}

	public void turn(){
		particles.forEach(p -> p.setPosition(p.getPosition().next()));
	}
	
	public void turnReverse(){
		particles.forEach(p -> p.setPosition(p.getPosition().previous()));
	}


	public List<Particle> getParticles() {
		return particles;
	}


	public void setParticles(List<Particle> particles) {
		this.particles = particles;
	}
	
	
}
