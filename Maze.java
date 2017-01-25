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

	frame.setPreferredSize(new Dimension(500,400));
	frame.setMinimumSize(new Dimension(500,400));
	frame.setMaximumSize(new Dimension(500,400));
	frame.setResizable(false);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true); 
	
	JPanel panel1 = new JPanel();// this is the main panel where the game will be shown
	frame.getContentPane().add(panel1);// add panel to frame
	panel1.setLayout(new BorderLayout());
	Maze m = new Maze();
	m.readMaze();
	panel1.add(m, BorderLayout.CENTER);
		
	frame.pack();
	
	//SET JPANEL BACKGROUND COLOUR
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
			g.drawRect(coordinates.get(i).getX(), coordinates.get(i).getY(), 12, 12); 
			g.fillRect(coordinates.get(i).getX(), coordinates.get(i).getY(), 12, 12);
		  }
	}
	
}