import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ControlPanel extends JPanel{
//this method makes objects to put in another JPanel, good way to do?
	public ControlPanel(){
	    JButton reset = new JButton("Reset");
	    JButton help = new JButton("Help");
	    JButton button = new JButton("Move");
	    JTextField textfield = new JTextField();
	
	    add(reset);
	    add(help);
	    add(button);
	    add(textfield);
	    
	reset.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
		   
		   }});
	
	help.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			   
		   }});
		   
	button.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			
		}});
}}
	
