import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * This class handles the functions of moving, dragging, linking the front train, the Cars and the block stack
 */
@SuppressWarnings("serial")
public class GraphicLinkedPanel extends JPanel implements MouseMotionListener 
{
	public static ArrayList<Train> objects;
	private Train selectedObject;

	/**
	 * The constructor for the Panel class
	 */
	public GraphicLinkedPanel()
	{
		MouseAdapter mouseListener = new MouseAdapter()
		{
			public void mousePressed(MouseEvent event)
			{
				addTrain(event);
				if(doneAdding())
				{
					for(int i = 0; i < objects.size(); i++)
					{
						if(objects.get(i).hasPrevious() == false && objects.get(i).getRect().contains(event.getPoint()))
						{
							selectedObject = objects.get(i);
							break;
						}
					}
				}
			}//End mouse Pressed

			public void mouseReleased(MouseEvent event)
			{
				for(Train obj : objects)
				{
					if(doneAdding() && selectedObject!= null)
					{
						if ( obj.getRect().intersects(selectedObject.getRect()))
						{
							obj.next = selectedObject;
						}
					}
					selectedObject = null;
				}		
			}//End Mouse Released
		};

		this.addMouseListener(mouseListener);
		this.addMouseMotionListener(this);

		ActionListener actionListener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				repaint();
			}
		};

		int DELAY = 50;
		Timer timer = new Timer(DELAY, actionListener);
		timer.start();
		objects = new ArrayList<Train>();
	}//End Constructor

	/**
	 * Check for correct amount of Trains
	 * @return whether there is enough Trains on the screen
	 */
	public boolean doneAdding()
	{
		return (objects.size() >= 7);
	}

	/**
	 * Places Train on stage
	 * @param event the mouse event
	 */
	public void addTrain(MouseEvent event)
	{
		if(objects.size() == 0)
		{
			objects.add(new FrontTrain(event.getX(), event.getY(), null));
		} 
		else if(objects.size() < 6)
		{
			objects.add(new Cart(event.getX(), event.getY(), null));
		}
		else if(objects.size() == 7)
		{
			objects.add(new BlockStack(event.getX(), event.getY(), null));
		}
	}

	/**
	 * Draw all required graphics
	 * @param g the graphics object
	 */
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		for(Train Train : objects)
		{
			if(Train.hasPrevious() == false)
			{
				if(Train.equals(selectedObject)) g2.setColor(Color.red);
				else g2.setColor(Color.black);
				Train.draw(g2);
			}
		}
	}

	/**
	 * Occurs when the mouse drags Train
	 * @param event the mouse event
	 */
	public void mouseDragged(MouseEvent event) 
	{
		if(doneAdding() && selectedObject!= null)
			selectedObject.moveTo(event.getX(), event.getY());
	}

	/**
	 * Move FrontTrain in x direction
	 * @param x
	 */
	public void moveXDir(int x)
	{
		objects.get(0).moveX(x);
	}

	/**
	 * Move FrontTrain in y direction
	 * @param y
	 */
	public void moveYDir(int y)
	{
		objects.get(0).moveY(y);
	}

	/**
	 * Move FrontTrain in random direction
	 * @param x
	 * @param y
	 */
	public void moveRand(int x, int y)
	{
		objects.get(0).moveRandXY(x,y);
	}

	/**
	 * @param event the mouse event
	 */
	public void mouseMoved(MouseEvent event) {}
	
	/**
	 * Clears the stage of objects(FrontTrains and cars)
	 */
	public void clearList()
	{
		objects.clear();
	}
	
}//End GraphicLinkedPanel Class