import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Maze extends JPanel {

	public Scanner file;	
	private int x;
	private int y;
	private int score;
	public int[][] Labyrinth;
	private Dexter D;
	
	ControlPanel c = new ControlPanel(this);
	
	KeyListener key = new KeyListener();
	
	public void actionPerformed(ActionEvent e){
    	repaint();
    }
	
	public int[][] readMaze(){ //reads the input file
		try{
			file = new Scanner(new File("Maze3.txt"));
			x = file.nextInt();
			y = file.nextInt();
		}
		catch(Exception except){
			System.out.println("No file found.");
		}
		
		Labyrinth = new int[x][y];
		System.out.printf("(%s,%s) \n", x, y);
		
		for (int r = 0; r < y ; r++){ //y
			for (int c = 0; c < x ; c++){ //x
				Labyrinth[c][r] = file.nextInt();
			}
		}
		file.close();
		D = new Dexter(0, 0, Labyrinth);
		setFocusable(true);
		requestFocusInWindow();
		addKeyListener(key);
        
		return Labyrinth;
	}
	
	@Override
	public void paintComponent(Graphics g) {//creates a maze from the input file
		super.paintComponent(g);
		ImageIcon Floppy = new ImageIcon("C:\\Users\\Udo\\workspace\\Final Project 2\\src\\Floppy disc 1.png");
		ImageIcon RAM = new ImageIcon("C:\\Users\\Udo\\workspace\\Final Project 2\\src\\RAM 2.png");
		ImageIcon EndGame = new ImageIcon("C:\\Users\\Udo\\workspace\\Final Project 2\\src\\End Game.png");
			
		for (int i = 0; i < Labyrinth.length; i++){
		     for (int j = 0; j < Labyrinth[i].length; j++){
		    	 if (Labyrinth[i][j] == Decoder.OPEN.getDecoder()) { // paths
		    		 g.setColor(Color.WHITE);
		    		 g.drawRect(i*16, j*16, 16, 16);		    		 
		    	 	 g.fillRect(i*16, j*16, 16, 16);}  
		    	 
		    	 else if (Labyrinth[i][j] == Decoder.WALL.getDecoder()){ // walls
		    		 g.setColor(Color.DARK_GRAY);
		    		 g.drawRect(i*16, j*16, 16, 16);		    		 
		    	 	 g.fillRect(i*16, j*16, 16, 16);}  
		    	 
		    	 else if (Labyrinth[i][j] == Decoder.START.getDecoder()){// start
		    		 g.setColor(Color.YELLOW);
		    		 g.drawRect(i*16, j*16, 16, 16);		    		 
		    	 	 g.fillRect(i*16, j*16, 16, 16);}  
		    	 
		    	 else if (Labyrinth[i][j] == Decoder.RAM.getDecoder()){// memory (RAM) to collect
    				 g.drawImage(RAM.getImage(), i*16, j*16, null);}
		    	 
		    	 else if (Labyrinth[i][j] == Decoder.END.getDecoder()){// end 
		    		 g.setColor(Color.RED);
		    		 g.drawRect(i*16, j*16, 16, 16);		    		 
		    	 	 g.fillRect(i*16, j*16, 16, 16);
		    	 	 g.drawImage(Floppy.getImage(), i*16, j*16, null);}  
		
		    	 else {//used to show errors in array
		    		 g.setColor(Color.PINK);
		    		 g.drawRect(i*16, j*16, 16, 16);		    		 
		    	 	 g.fillRect(i*16, j*16, 16, 16);}  
		     }
		}
		 
		g.drawImage(D.getDexter(), D.getX()*16, D.getY()*16, null);
		
		if (Labyrinth[D.getX()][D.getY()] == Decoder.RAM.getDecoder()){//when Dexter is at a RAM location
			g.setColor(Color.WHITE);
			g.drawRect(D.getX()*16, D.getY()*16, 16, 16);
			Labyrinth[D.getX()][D.getY()] = 0; //update array
			score += 1024;
			c.getBytes().setText(getScore() + "MB");
			System.out.println(c.getBytes().getText());
		}
		if (Labyrinth[D.getX()][D.getY()] == Decoder.END.getDecoder()){//end game when file is found
			g.drawImage(EndGame.getImage(), 0, 0, null);
			Labyrinth[D.getX()-1][D.getY()] = 1;
		}
	}
	
	public class KeyListener extends KeyAdapter{
    	    
		@Override
    		public void keyPressed(KeyEvent e){
    			int key = e.getKeyCode();
    			
    			if (key == KeyEvent.VK_UP){
    				D.move(0, -1, Labyrinth);
    			}
    			
				if (key == KeyEvent.VK_DOWN){
					D.move(0, 1, Labyrinth);				
				}
				
				if (key == KeyEvent.VK_LEFT){
					D.move(-1, 0, Labyrinth);
				}

				if (key == KeyEvent.VK_RIGHT){
					D.move(1, 0, Labyrinth);
				}
				
				if (e.isControlDown() && key == KeyEvent.VK_R){
					reset();
				}
				//System.out.printf("Location: %d, %d \n", D.getX(), D.getY());
				repaint(); //repaints window any time there is an update in player position
				c.getLoc().setText(String.format("Location: %d, %d", D.getX(), D.getY()));
				System.out.println(c.getLoc().getText());
    		}
	}
	
	public Dexter getPlayer(){
		return D;
	} 

	public int getScore(){
//		System.out.print(score);
		return score;
	}
	
	public void reset(){
		removeKeyListener(key); //remove (reset) the key listener before it is added again in readMaze
		readMaze();
		repaint();
		score = 0;
	}
}