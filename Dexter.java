import java.awt.Image;

import javax.swing.ImageIcon;
//point class from checker board
public class Dexter {
	private int x;
	private int y;
	private Image Dexter;
	
	public Dexter(int x, int y){
		this.x = x;
		this.y = y;
		
		ImageIcon image = new ImageIcon("C:\\Users\\Udo\\workspace\\Final Project 2\\src\\Dexter_Icon.jpg");
		Dexter = image.getImage();
		
		x = 0;
		y = 0;
	}
	
	public Image getDexter(){
		return Dexter;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}

	public void reset(){
		x = 0;
		y = 0;
	}
	
	public void move(int x, int y, int[][] Maze){
		//get move
		
		//check if move is valid
		//update location if valid
			if (Maze[x][y] != 0) {
				this.x += x;
				this.y += y; //put dexter at x,y
		    }
	
}}

/*
 * Control class (add to panel2)
 * create something to pop open a new window
buttons needed- help, reset, move 
text field */ 
//add a player

