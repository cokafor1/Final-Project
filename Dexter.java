import java.awt.Image;

import javax.swing.ImageIcon;
//point class from checker board
public class Dexter {
	private int x;
	private int y;
	private Image Dexter;
	
	public Dexter(int x, int y, int[][] Maze){
		//PASS 2d ARRAY AND USE FOR LOOP TO FIND 2 (get VALS TO ASSIGN X,Y)
		
		//OR INITIALIZE BEFORE I CREATE IT 
		
		
		
		for (int i = 0; i < Maze.length; i++){
		     for (int j = 0; j < Maze[i].length; j++){
		    	 if (Maze[i][j] == Decoder.START.getDecoder()) { // paths
		    		 x = j;
		 			 y = i;
		    	 }
		     }
		}
		
		this.x = x;
		this.y = y;
		
		ImageIcon image = new ImageIcon("C:\\Users\\Udo\\workspace\\Final Project 2\\src\\Dexter_Icon.jpg");
		Dexter = image.getImage();

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
		int moveX = (this.x + x);
		int moveY = (this.y + y);
		
		if (moveX >= 0 && moveY >= 0){
			if(Maze[moveX][moveY] == Decoder.START.getDecoder()) { //check if move is valid
				this.x = moveX;
				this.y = moveY; // put dexter at index, update location
			}
			else if(Maze[moveX][moveY] == Decoder.OPEN.getDecoder()) { //check if move is valid
				this.x = moveX;
				this.y = moveY;
			}
			else if(Maze[moveX][moveY] == Decoder.WALL.getDecoder()) { //check if move is valid
				this.x = this.x;
				this.y = this.y; // don't move, keep same index
			}
			else if(Maze[moveX][moveY] == Decoder.END.getDecoder()) { //check if move is valid
				this.x = moveX;
				this.y = moveY;
			}
		}
	}
}

/*
 * Control class (add to panel2)
 * create something to pop open a new window
buttons needed- help, reset, move 
text field */ 
//add a player

