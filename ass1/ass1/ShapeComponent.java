package ass1;

import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.*;
import java.awt.Color;

@SuppressWarnings("serial")
public class ShapeComponent extends JComponent{

	
	
	Rectangle box;
	
	ShapeComponent()
	{
	    //-----------Start below here. To do: approximate lines of code = 1
	    // 1. box =    ... put in some rectangle
	    box =  new Rectangle(20,800,50,15);
	    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
	
	public void paintComponent(Graphics g)
	{  
		// Recover Graphics2D
		Graphics2D g2 = (Graphics2D) g;
     
		// Change the color
		//Color c = new Color(1.0F,0.0F,1.0F); 
		//g2.setColor(c);
   
		// Draw a rectangle
		g2.draw(box);

		// Move rectangle 15 units to the right and 25 units down
		//box.translate(15, 25);

		// Draw moved rectangle
		//g2.draw(box);
   
		Ellipse2D.Double e = new Ellipse2D.Double(90,800,50,15);
		g2.fill(e);
   
   
		//g2.setColor(Color.BLUE);
		//Point2D.Double p1 = new Point2D.Double(25.0,50.0);
		//Point2D.Double p2 = new Point2D.Double(100.0,250.0);
		//Line2D.Double line = new Line2D.Double(p1,p2);
		//g2.draw(line);
		
		g2.drawString("hello graphics world!",800,800);
   
	}
	
}
