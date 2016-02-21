package ass1;
import java.awt.Graphics;
//import java.awt.Graphics2D;
import javax.swing.JComponent ;
import java.awt.event.MouseListener ;
import java.awt.event.MouseEvent ;


/**
Component that draws that is moved my a mouse.
*/
@SuppressWarnings("serial")
public class graphMouseComponent extends JComponent
{
	    public graphMouseComponent()
	    {  
		/*
		  Make a listener that responds to mouse events.
		  It moves the snow person to the mouse position.
		 */
		class MyListener implements MouseListener
		{
		    public void mousePressed(MouseEvent event)
		    {
		    	repaint() ;
		    }
		    public void mouseReleased(MouseEvent event)
		    {
		    	repaint() ;
		    }
		    public void mouseClicked(MouseEvent event)
		    {
		    	repaint() ;
		    }
		    public void mouseEntered(MouseEvent event)
		    {
		    	repaint() ;
		    }
		    public void mouseExited(MouseEvent event)
		    {
		    	repaint() ;
		    }
		}
		MouseListener listener = new MyListener() ;
		this.addMouseListener(listener) ;
	    }

	   
	    public void paintComponent(Graphics g)
	    {  
		super.paintComponent(g) ;
		//Graphics2D g2 = (Graphics2D)g;
		//person.draw(g2) ;
	    }
	    

}
