import java.awt.Image;

import javax.swing.ImageIcon;

public class Dexter {
	private int x;
	private int y;
	private Image Dexter;
	
	public Dexter(){
		
		ImageIcon image = new ImageIcon("C:\\Users\\Udo\\Desktop\\Ballet\\yellow square.png");
		Dexter = image.getImage();
	}
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}

}
