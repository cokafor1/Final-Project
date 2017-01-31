import java.awt.Image;

import javax.swing.ImageIcon;
//point class from checker board
public class Dexter {
	private int x;
	private int y;
	private int pos;
	private Image Dexter;
	
	public Dexter(int x, int y, int[][] Maze){
		
		this.x = x;
		this.y = y;
		
		ImageIcon image = new ImageIcon("C:\\Users\\Udo\\workspace\\Final Project 2\\src\\Dexter_Icon.jpg");
		Dexter = image.getImage();
		
		x = 1;
		y = 0;
		
		int pos = Maze[x][y];
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
		y = 12;
	}
	
	public void move(int x, int y, int[][] Maze){
		//get move
		int moveX = (this.x + 1);
		int moveY = (this.y + 1);
		
		if (Maze[moveX][moveY] == 0) { //check if move is valid
			this.x += 1;
			this.y += 1; // put dexter at x,y update location if valid
		}
		else if (Maze[moveX][moveY] == 1){
			this.x = x;
			this.y = y;
		}
		else{
			this.x += 1;
			this.y += 1;
		}
		}
	
	}
	


/*
 * Control class (add to panel2)
 * create something to pop open a new window
buttons needed- help, reset, move 
text field */ 
//add a player

