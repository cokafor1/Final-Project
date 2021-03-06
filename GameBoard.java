import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameBoard extends JPanel{
	
	public static void main(String[] args){		
			
			Maze m = new Maze();
			m.readMaze();
			
			ControlPanel control = new ControlPanel(m);
			
			m.setControlPanel(control);
			
			control.getBytes().setText(m.getScore() + "MB");
			control.getLoc().setText(String.format("Location: %d, %d", m.getPlayer().getX(), m.getPlayer().getY()));;
			
			JFrame frame = new JFrame("Dexter's Labyrinth");

			JPanel panel1 = new JPanel();// this is the main panel where the game will be shown
			JPanel panel2 = new JPanel();//this is the control area
			
			panel1.setLayout(new BorderLayout());
			panel1.setBackground(Color.WHITE);
			panel2.setBackground(Color.GRAY);
			
			panel1.add(m);//add the maze to the center of the top panel
			panel2.add(control);
			
			frame.add(panel1, BorderLayout.CENTER);
			frame.add(panel2, BorderLayout.PAGE_END);
			
			frame.setPreferredSize(new Dimension(664,574));
			frame.setMinimumSize(new Dimension(664,574));
			frame.setMaximumSize(new Dimension(664,574));
			frame.setResizable(false);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);

	}
}