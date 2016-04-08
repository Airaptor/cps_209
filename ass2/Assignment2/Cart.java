import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
   A Cart shape that can be positioned anywhere on the screen.
 */
public class Cart extends Train
{
	private int xLeft;
	private int yTop;
	private Rectangle2D.Double body;
	private Ellipse2D.Double frontTire, rearTire;
	private Point2D.Double r5,r6;
	private Line2D.Double hitch;
    public static final int UNIT = 10 ;
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
      Constructs a Cart with a given top left corner.
      @param x the x coordinate of the top left corner
      @param y the y coordinate of the top left corner
	 */
	public Cart(int x, int y, Train next)
	{
		super(x,y,next);
		
	}//End Constructor

	/**
      Draws the Cart.
      @param g2 the graphics context
	 */
	public void draw(Graphics2D g2)
	{
		 xLeft = getRect().x;
		 yTop = getRect().y;
		 body = new Rectangle2D.Double(xLeft, yTop + UNIT, U6, UNIT);     
		 frontTire = new Ellipse2D.Double(xLeft + UNIT, yTop + U2, UNIT, UNIT);
		 rearTire = new Ellipse2D.Double(xLeft + U4, yTop + U2, UNIT, UNIT);
		// the right end of the hitch
		r5 = new Point2D.Double(xLeft + U6, yTop + U15);
		// the left end of the hitch
		r6  = new Point2D.Double(xLeft + U6 + U05, yTop + U15);
			
		hitch = new Line2D.Double(r5, r6);

		g2.draw(body);
		g2.draw(hitch);
		g2.draw(frontTire);
		g2.draw(rearTire);
		g2.draw(body) ;

		
		if(hasNext())
		{
			g2.drawLine(getRect().x, getRect().y, getNext().getRect().x, getNext().getRect().y);			
			getNext().draw(g2);
		}
	}//End draw method

	/**
	 * @return Rectangle bounding box of Cart
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
	 * @return Cart that would be next
	 */
	public Train getNext()
	{
		if(!hasNext()) 
			return null;
		else 
			return next;
	}

	/**
	 * Make selected Cart next
	 * @param the next Train
	 */
	public void setNext(Train next)
	{
		this.next = next;
	}

	/**
	 * @return if Cart has previous
	 */
	public boolean hasPrevious()
	{
		return (previous != null);
	}
	
	/**
	 * @return Cart the would be previous
	 */
	public Train getPrevious()
	{
		if(!hasPrevious()) 
			return null;
		else 
			return previous;
	}

	/**
	 * Make selected Cart previous
	 * @param the previous Cart
	 */
	public void setPrevious(Train previous) 
	{
		this.previous = previous;
	}

	/**
	 * Move Cart
	 * @param x
	 * @param y
	 */
	public void moveTo(int x, int y)
	{
		this.x = x;
		this.y = y ;
	}

}//End Cart Class