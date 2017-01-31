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
	public int[][] Maze;
	private Dexter D;
	
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
		
		for (int r = 0; r < y ; r++){
			for (int c = 0; c < x ; c++){
				Maze[c][r] = file.nextInt();
			}

			System.out.println(Arrays.toString(Maze[r]));
		}
		//System.out.println(Arrays.deepToString(Maze));
		file.close();
		D = new Dexter(0,0);
			if (Maze[i][j] == 2){
				Dexter.move(i, j, Maze[i][j]);}
	}
	
	//generate a 2D array and use special characters to define treasures and special points
	
	//compare if equal (==) to # or . then say, maze at that pos (r,c) equals open
	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < Maze.length; i++){
		     for (int j = 0; j < Maze[i].length; j++){
		    	 if (Maze[i][j] == 0) { // paths
		    		 g.setColor(Color.WHITE);
		    		 g.drawRect(i*12, j*12, 12, 12);		    		 
		    	 	 g.fillRect(i*12, j*12, 12, 12);}  
		    	 
		    	 else if (Maze[i][j] == 1){ // walls
		    		 g.setColor(Color.DARK_GRAY);
		    		 g.drawRect(i*12, j*12, 12, 12); 
		    		 g.fillRect(i*12, j*12, 12, 12);}
		    	 
		    	 else if (Maze[i][j] == 2){// start
		    		 g.setColor(Color.YELLOW);
		    		 g.drawRect(i*12, j*12, 12, 12); 
		    		 g.fillRect(i*12, j*12, 12, 12);}
		    	 
		    	 else if (Maze[i][j] == 3){// end 
		    		 g.setColor(Color.RED);
		    		 g.drawRect(i*12, j*12, 12, 12);
		    		 g.fillRect(i*12, j*12, 12, 12);}
		    	 	
		    	 else {
		    		 g.setColor(Color.PINK);
		    		 g.drawRect(i*12, j*12, 12, 12);
		    		 g.fillRect(i*12, j*12, 12, 12);}
		    }
			
		  }
		 
		g.drawImage(D.getDexter(), D.getX(), D.getY(), null);
		
	}
	
	

	
//	private Dexter p;	
//	 public void actionPerformed(ActionEvent e){
//	    	repaint();
//	    }
	
}