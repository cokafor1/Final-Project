import java.awt.Image;

import javax.swing.ImageIcon;
//point class from checker board
public class Dexter {
	private int x;
	private int y;
	private Image Dexter;
	
	public Dexter(int x, int y){
		
		ImageIcon image = new ImageIcon("C:\\Users\\Udo\\Desktop\\Ballet\\yellow square.png");
		Dexter = image.getImage();
	}
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}

//	public boolean chekPos(Pair coordinate){// how to check if in correct path
//		if (getX()&getY() in coordinates){
//		}
//	} 
	
}

/*
 * Control class (add to panel2)
 * create something to pop open a new window
buttons needed- help, reset, move 
text field */ 
//add a player

