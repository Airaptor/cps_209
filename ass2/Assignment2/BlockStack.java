import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
   A BlockStack that can be positioned anywhere on the screen.
 */
public class BlockStack extends Train
{
	private int xLeft;
	private int yTop;
	private Rectangle2D.Double boxA, boxB, boxC, boxD, boxE, bottomBlock;
    public static final int UNIT = 30 ;
    public static final int U6 = 6 * UNIT ;
    public static final int U5 = 5 * UNIT ;
    public static final int U4 = 4 * UNIT ;
    public static final int U3 = 3 * UNIT ;
    public static final int U2 = 2 * UNIT ;
    public static final int U15 = UNIT + UNIT / 2 ;
    public static final int U05 =  UNIT / 2 ;
    public static final int BODY_WIDTH = U3 ;
    public static final int BODY_HEIGHT = U2 ;

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
		 bottomBlock = new Rectangle2D.Double(xLeft, yTop + UNIT, UNIT, UNIT/2);     
		 boxA = new Rectangle2D.Double(xLeft, yTop - U2 - UNIT , UNIT, UNIT);
		 boxB = new Rectangle2D.Double(xLeft, yTop - U3 - UNIT, UNIT, UNIT);
		 boxC = new Rectangle2D.Double(xLeft, yTop - U4 - UNIT, UNIT, UNIT);
		 boxD = new Rectangle2D.Double(xLeft, yTop - U5 - UNIT, UNIT, UNIT);
		 boxE = new Rectangle2D.Double(xLeft, yTop - U6 - UNIT, UNIT, UNIT);
		 
		g2.fill(bottomBlock);
		g2.draw(boxA);
		g2.draw(boxB);
		g2.draw(boxC);
		g2.draw(boxD);
		g2.draw(boxE);

		
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
	 * @param the next BlockStack
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


}//End BlockStack Class
