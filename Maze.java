import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Maze extends JPanel {

	public Scanner file;	
	private int x;
	private int y;
	public int[][] Maze;
	public Dexter D;
	
//	public void actionPerformed(ActionEvent e){
//    	repaint();
//    }
	
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
		
		for (int r = 0; r < y ; r++){ //y
			for (int c = 0; c < x ; c++){ //x
				Maze[c][r] = file.nextInt();
			}
		}
		
		System.out.println(Arrays.deepToString(Maze));
		file.close();
		
		D = new Dexter(1, 0, Maze);
		addKeyListener(new KeyListener());
        setFocusable(true);
	}
	
		
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < Maze.length; i++){
		     for (int j = 0; j < Maze[i].length; j++){
		    	 if (Maze[i][j] == Decoder.OPEN.getDecoder()) { // paths
		    		 g.setColor(Color.WHITE);
		    		 g.drawRect(i*12, j*12, 12, 12);		    		 
		    	 	 g.fillRect(i*12, j*12, 12, 12);}
		    	 	 //g.drawImage(D.getDexter(), i*12, j*12, null);}  
		    	 
		    	 else if (Maze[i][j] == Decoder.WALL.getDecoder()){ // walls
		    		 g.setColor(Color.DARK_GRAY);
		    		 g.drawRect(i*12, j*12, 12, 12); 
		    		 g.fillRect(i*12, j*12, 12, 12);}
		    	 
		    	 else if (Maze[i][j] == Decoder.START.getDecoder()){// start
		    		 g.setColor(Color.YELLOW);
		    		 g.drawRect(i*12, j*12, 12, 12); 
		    		 g.fillRect(i*12, j*12, 12, 12);}
		    	 
		    	 else if (Maze[i][j] == Decoder.END.getDecoder()){// end 
		    		 g.setColor(Color.RED);
		    		 g.drawRect(i*12, j*12, 12, 12);
		    		 g.fillRect(i*12, j*12, 12, 12);}
		    	 	
		    	 else {
		    		 g.setColor(Color.PINK);
		    		 g.drawRect(i*12, j*12, 12, 12);
		    		 g.fillRect(i*12, j*12, 12, 12);}
		    }
			
		  }
		 
		g.drawImage(D.getDexter(), D.getX()*12, D.getY()*12, null);
		
	}
	
	public class KeyListener extends KeyAdapter{
    	    	
    		public void keyPressed(KeyEvent e){
    			int key = e.getKeyCode();
    			
    			if (key == KeyEvent.VK_UP){
    				D.move(0, -1, Maze);
    			}
    			
				if (key == KeyEvent.VK_DOWN){
					D.move(0, 1, Maze);				
				}
				
				if (key == KeyEvent.VK_LEFT){
					D.move(-1, 0, Maze);
				}

				if (key == KeyEvent.VK_RIGHT){
					D.move(1, 0, Maze);
				}
				
				if (key == KeyEvent.VK_R ){
					D.reset();
				}
				
				repaint();
    		}
}}