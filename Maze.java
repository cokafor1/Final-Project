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
	
	
	public static void main(String[] args){
//create empty array list
// read file, get integers. Get integers as pairs in comma separated list
// write getX(), getY() function
//print rectangle in that coordinate pair, find layout manager for maze
	
	JFrame frame = new JFrame("Maze"); 
	Maze m = new Maze();
	m.readMaze();
	frame.setContentPane(new Maze());
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.pack();
	frame.setSize(250,250);
	frame.setVisible(true);  
	}
		
	public void readMaze(){
		try{
			file = new Scanner (new File("Maze.txt"));
		}
		catch(Exception except){
			System.out.println("No file found.");
		}
		
		while (file.hasNext()){
			x = file.nextInt();
			y = file.nextInt();
			Pair pair = new Pair(x, y);
			// print rectangle with x and y as positions
			System.out.printf("(%s,%s) \n", pair.getX(), pair.getY());
			coordinates.add(pair);
		}
	}//gives me arraylist of Pair objects (coordinates)
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < coordinates.size(); i++){
			g.drawRect(x, y, 10, 10); 
			g.fillRect(pair.getX(), getY(), 10, 10);
		  }
	}
	
}

//	public void paint(Graphics g) {    
//	    g.drawRect(0,0,100,100); //(loc, loc, width, height)
//		Rectangle r = new Rectangle(xPos,yPos,width,height);
//	    g.fillRect(r.getX(), r.getY(), r.getWidth(), r.getHeight());  //make a function that gets x and y pair from array
//	}
