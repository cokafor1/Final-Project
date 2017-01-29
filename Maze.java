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
	private Pair pair;	
	
//take main and put in separate file that will create maze, read and add the panel
//gameboard class with two panels
	

/*create empty array list, read file, get integers. Get integers as pairs in comma separated list.
write getX(), getY() function to print rectangle in that coordinate pair, find layout manager for maze */

	public void readMaze(){
		try{
			file = new Scanner(new File("Maze3"));
			x = file.nextInt();
			y = file.nextInt();
			
		}
		catch(Exception except){
			System.out.println("No file found.");
		}
		

		
		int Maze[][] = new int[x][y];
		
		for (int r = 0; r < x && file.hasNextLine(); r++){
			for (int c = 0; c < y && file.hasNextInt(); c++){
				Maze[r][c] = file.nextInt();
		}
			file.nextLine();
			}
		
		System.out.printf("(%s,%s) \n", x, y);
		
		
		//System.out.println(Maze[x][y]);
		file.close();
	}
	
	
//	public void readMaze(){
//		try{
//			file = new Scanner (new File("Maze2.txt"));
//		}
//		catch(Exception except){
//			System.out.println("No file found.");
//		}
//		
//		while (file.hasNext()){
//			x = file.nextInt();
//			y = file.nextInt();
//			Pair pair = new Pair(x, y);
//			// print rectangle with x and y as positions
//			System.out.printf("(%s,%s) \n", pair.getX(), pair.getY());
//			coordinates.add(pair);
//		}
//	}//gives me arraylist of Pair objects (coordinates)
	//generate a 2D array and use special characters to define treasures and special points
	// int[][] = new int[getX()][getY()]
	//int size = runtime decides
	//int[][] = new int[getX()][size]
	//put size above line
	
			
	
	//compare if equal (==) to # or . then say, maze at that pos (r,c) equals open
	//enum{open = 1
	//wall = 2
	//* = 3}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < coordinates.size(); i++){
			g.drawRect(coordinates.get(i).getX(), coordinates.get(i).getY(), 12, 12); 
			g.fillRect(coordinates.get(i).getX(), coordinates.get(i).getY(), 12, 12);
		  }
	}
	//if, then, else for paintcomponent
	
}