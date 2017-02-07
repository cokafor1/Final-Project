import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ControlPanel extends JPanel{
//this method makes objects to put in another JPanel, good way to do?
	private JLabel bytes;
	private JLabel location;
	public Maze x;
	
	public ControlPanel(Maze newLabyrinth){
	    
		x = newLabyrinth;
		
		JButton reset = new JButton("Reset/Play Again");
		reset.setFocusable(false);
	    JButton help = new JButton("Help");
	    help.setFocusable(false);
	    JButton up = new JButton("Up");
	    up.setFocusable(false);
	    JButton down = new JButton("Down");
	    down.setFocusable(false);
	    JButton left = new JButton("Left");
	    left.setFocusable(false);
	    JButton right = new JButton("Right");
	    right.setFocusable(false);
	    
	    location = new JLabel();
	    location.setFocusable(false);
	    bytes = new JLabel("MB"); //to avoid null pointer, create global variable and then initialize it here in the method
	   	bytes.setFocusable(false);
	   	
	    add(help);
	    add(reset);
	    add(bytes);
	    add(up);
	    add(down);
	    add(left);
	    add(right);
	    add(location);
	    
	reset.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			x.reset();
		   }});
	
	help.addActionListener(new ActionListener(){ //open help dialog box
		public void actionPerformed(ActionEvent e){
            ImageIcon DeeDee = new ImageIcon("C:\\Users\\Udo\\workspace\\Final Project 2\\src\\DeeDee_Icon2.jpg");
            JOptionPane.showMessageDialog(null,
		                "Dee Dee has infected Dexter's computer\n"
		                + "with a virus! Now Dexter must shrink \n"
		                + "himself and go inside his computer....\n\n"
		                + "Using the arrow keys, guide Dexter through\n"
		                + "the system to find the infected file. In\n"
		                + "the mean time, save as much memory as\n"
		                + "possible to restore later.", "Help", JOptionPane.INFORMATION_MESSAGE, DeeDee);
		   }});
		   
	up.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			x.getPlayer().move(0, -1, x.Labyrinth);
			//x.reset();
		}});
	
	down.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			//x.getPlayer().move(0, 1, x.Labyrinth);
		}});
	
	left.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			x.getPlayer().move(-1, 0, x.Labyrinth);
		}});
	
	right.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			x.getPlayer().move(1, 0, x.Labyrinth);
		}});
	}

	public JLabel getBytes(){
		return bytes;
	}

	public JLabel getLoc(){
		return location;
	}
	
//	public void showLoc(int a, int b){
//		System.out.printf("Location: %d, %d", x.getPlayer().getX(), x.getPlayer().getY());
//		location.setText(String.format("Location: %d, %d", x.getPlayer().getX(), x.getPlayer().getY()));
//	}
}
/*MAIN ISSUES-
 * Communication between Control Panel and Maze
 * Direction buttons don't work
 * Labels don't update in GUI but print correctly
 */	
