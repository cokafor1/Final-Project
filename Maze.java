import java.awt.*;
import java.io.File;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Maze extends JPanel {

	public Scanner file;	
	private int x;
	private int y;
	public static ArrayList<Pair> coordinates = new ArrayList<>();
	public int Maze[][];
	
//take main and put in separate file that will create maze, read and add the panel
//gameboard class with two panels
	
	public void readMaze(){
		try{
			file = new Scanner(new File("Maze3.txt"));
			x = file.nextInt();
			y = file.nextInt();
			
		}
		catch(Exception except){
			System.out.println("No file found.");
		}
		
		Maze = new int[x][y];
		System.out.printf("(%s,%s) \n", x, y);
		
		for (int r = 0; r < x && file.hasNextLine(); r++){
			for (int c = 0; c < y && file.hasNextInt(); c++){
				Maze[r][c] = file.nextInt();
			}

			System.out.println(Arrays.toString(Maze[r]));
		}
		//System.out.println(Arrays.deepToString(Maze));
		file.close();
	}
	
	//generate a 2D array and use special characters to define treasures and special points
	// int[][] = new int[getX()][getY()]
	//int size = runtime decides
	//int[][] = new int[getX()][size]
	//put size above line
	
			
	
	//compare if equal (==) to # or . then say, maze at that pos (r,c) equals open
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < Maze.length; i++){
		     for (int j = 0; j < Maze[i].length; j++){
		    	 if (Maze[i][j] == 0) {
		    		 g.drawRect(i, j, 12, 12);
		    		 g.setColor(Color.BLACK);
		    	 	 g.fillRect(i, j, 12, 12);}  
		    	 
		    	    else if (Maze[i][j] == 1){
		    	    	g.drawRect(i, j, 12, 12); 
		    	    	g.setColor(Color.BLUE);
	    	 	 		g.fillRect(i, j, 12, 12);}
		    	 
		    	    else if (Maze[i][j] == 2){
		    	    	g.drawRect(i, j, 12, 12); 
		    	    	g.setColor(Color.YELLOW);
	    	 	 		g.fillRect(i, j, 12, 12);}
		    	 
		    	    else {
		    	    	g.drawRect(i, j, 12, 12);
		    	    	g.setColor(Color.RED);
		    	 	 	g.fillRect(i, j, 12, 12);}
		    	 	
		    	  }
			
		  }
	}
	//if, then, else for paintcomponent
	
}