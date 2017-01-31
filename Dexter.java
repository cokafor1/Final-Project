import java.awt.Image;

import javax.swing.ImageIcon;
//point class from checker board
public class Dexter {
	private int x;
	private int y;
	private Image Dexter;
	
	public Dexter(int x, int y){
		
		this.x = 12*x;
		this.y = 12*y;
		
		ImageIcon image = new ImageIcon("C:\\Users\\Udo\\workspace\\Final Project 2\\src\\Dexter_Icon.jpg");
		Dexter = image.getImage();
		
		x = 12;
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
		y = 12;
	}
	
	public void move(int x, int y, int[][] Maze){
		//get move
		int tempX = (this.x + x)/12;
		int tempY = (this.y + y)/12;
		
		if (Maze[tempX][tempY] == 0) { //check if move is valid
			this.x += tempX/12;
			this.y += tempY/12; // put dexter at x,y update location if valid
		}
		else if (Maze[tempY][tempX] == 1){
			this.x = x/12;
			this.y = y/12;
		}
		else{
			this.x += tempX/12;
			this.y += tempY/12;
		}
		}
	
	}
	


/*
 * Control class (add to panel2)
 * create something to pop open a new window
buttons needed- help, reset, move 
text field */ 
//add a player

