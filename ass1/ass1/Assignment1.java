/**
 * 
 */
package ass1;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame ;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
   This program makes a frame and adds a panel to it.
   The panel will show Rectangle, Ellipses and connections around
   under the influence of a mouse.
   The creation of Labels and nodes
 */
/**
 * @author Thales Ferreira
 *
 */
public class Assignment1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		Panel p1=new Panel();
		Panel p2=new Panel();
		Panel p3=new Panel();
		
	    final int FRAME_WIDTH  = 1000;
	    final int FRAME_HEIGHT = 1000;
	    final int FRAME_HORIZONTAL  = 550;
	    final int FRAME_VERTICAL = 50;
		
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setLocation(FRAME_HORIZONTAL, FRAME_VERTICAL);
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setTitle("Graph Draw");
		
		
		p1.setLayout(new GridLayout(15,0));
		p2.setLayout(new GridLayout(1,73));
		p3.setLayout(new GridLayout(15,2));
		
		Button button_Rectangle = new Button("Rectangle");
		Button button_Ellipse = new Button("Ellipse");
		Button button_Edge = new Button("Edge");
		Button button_Label = new Button("Label");
		
		graphMouseComponent panel = new graphMouseComponent() ;
		ShapeComponent component = new ShapeComponent();
		TextField k=new TextField();
	    
		
		
		
		
		p1.add(button_Rectangle);
		p1.add(button_Ellipse);
		p1.add(button_Edge);
		p1.add(button_Label);
		p1.add(k);
		p1.add(panel);
		p1.add(component);
		frame.add(p1);
		
		
		frame.setVisible(true);
	}

	

}