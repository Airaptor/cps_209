import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
   A BlockStack that can be positioned anywhere on the screen.
 */
public class BlockStack extends Train
{
	private int xLeft;
	private int yTop;
	private Rectangle body;
	private Ellipse2D.Double frontTire, rearTire;
	private Point2D.Double r1,r2,r3,r4;
	private Line2D.Double frontWindshield,roofTop,rearWindshield;

	/**
      Constructs a BlockStack with a given Bottom left corner.
      @param x the x coordinate of the top left corner
      @param y the y coordinate of the top left corner
	 */
	public BlockStack(int x, int y, Train next)
	{
		super(x,y,next);
		
	}//End Constructor

	/**
      Draws the BlockStack.
      @param g2 the graphics context
	 */
	public void draw(Graphics2D g2)
	{
		 xLeft = getRect().x;
		 yTop = getRect().y;
		 body 
		= new Rectangle(xLeft, yTop + 10, 60, 10);      
		 frontTire 
		= new Ellipse2D.Double(xLeft + 10, yTop + 20, 10, 10);
		 rearTire
		= new Ellipse2D.Double(xLeft + 40, yTop + 20, 10, 10);

		 r1 
		= new Point2D.Double(xLeft + 10, yTop + 10);
		
		 r2 
		= new Point2D.Double(xLeft + 20, yTop);
		
		 r3 
		= new Point2D.Double(xLeft + 40, yTop);
		 
		 r4 
		= new Point2D.Double(xLeft + 50, yTop + 10);

		 frontWindshield 
		= new Line2D.Double(r1, r2);
		 
		 roofTop 
		= new Line2D.Double(r2, r3);
		
		 rearWindshield
		= new Line2D.Double(r3, r4);

		g2.draw(body);
		g2.draw(frontTire);
		g2.draw(rearTire);
		g2.draw(frontWindshield);      
		g2.draw(roofTop);      
		g2.draw(rearWindshield);

		if(hasNext())
		{
			g2.drawLine(getRect().x, getRect().y, getNext().getRect().x, getNext().getRect().y);			
			getNext().draw(g2);
		}
	}//End draw method

	/**
	 * @return Rectangle bounding box of BlockStack
	 */
	public Rectangle getRect() 
	{
		return new Rectangle(x, y, TRAIN_WIDTH, TRAIN_HEIGHT);
	}

	/**
	 * @return boolean if there is a next truck
	 */
	public boolean hasNext()
	{
		return (next != null);
	}

	/**
	 * @return BlockStack that would be next
	 */
	public Train getNext()
	{
		if(!hasNext()) 
			return null;
		else 
			return next;
	}

	/**
	 * Make selected BlockStack next
	 * @param the next Vehicle
	 */
	public void setNext(Train next)
	{
		this.next = next;
	}

	/**
	 * @return if BlockStack has previous
	 */
	public boolean hasPrevious()
	{
		return (previous != null);
	}
	
	/**
	 * @return BlockStack the would be previous
	 */
	public Train getPrevious()
	{
		if(!hasPrevious()) 
			return null;
		else 
			return previous;
	}

	/**
	 * Make selected BlockStack previous
	 * @param the previous BlockStack
	 */
	public void setPrevious(Train previous) 
	{
		this.previous = previous;
	}

	/**
	 * Move BlockStack
	 * @param x
	 * @param y
	 */
	public void moveTo(int x, int y)
	{
		this.x = x;
		this.y = y ;
	}

	@Override
	public void setNext(Train next) {
		// TODO Auto-generated method stub
		
	}

}//End BlockStack Class