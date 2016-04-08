import java.awt.geom.* ;
import java.awt.* ;

/**
   FrontTrain is a Train that can pull a chain of carts
 */
public class FrontTrain extends Train
{
	private int x1;
	private int y1;
	private static final double WIDTH = 50 ;
	private static final double UNIT = WIDTH / 7 ;
	private static final double LENGTH_FACTOR = 14 ; // length is 14U
	private static final double HEIGHT_FACTOR = 5 ; // height is 5U
	private static final double U_3 = 0.3 * UNIT ; 
	private static final double U2_5 = 2.5 * UNIT ; 
	private static final double U3 = 3 * UNIT ; 
	private static final double U4 = 4 * UNIT ; 
	private static final double U5 = 5 * UNIT ; 
	private static final double U10 = 10 * UNIT ; 
	private static final double U10_7 = 10.7 * UNIT ; 
	private static final double U12 = 12 * UNIT ; 
	private static final double U13 = 13 * UNIT ; 
	private static final double U14 = 14 * UNIT ; 

	/**
       Constructs FrontTrain at position
       @param x the x position
       @param y the y position
	 */
	public FrontTrain(int x, int y, Train next)
	{
		super(x,y,next);
		x1 = x;
		y1 = y;

	}//End Constructor 

	/**
	 @return Rectangle boundingBox
	 */
	public Rectangle getRect() 
	{
		return new Rectangle(x, y, TRAIN_WIDTH, TRAIN_HEIGHT);
	}

	/**
	 * @return boolean if there is a next FrontTrain
	 */
	public boolean hasNext()
	{
		return (next != null);
	}

	/**
	 * @return Train that would be next
	 */
	public Train getNext()
	{
		if(!hasNext()) 
			return null;
		else 
			return next;
	}

	/**
	 * make Selected Train next
	 * @param next of Train
	 */
	public void setNext(Train next)
	{
		this.next = next;
	}

	/**
	 * @return boolean if has a previous
	 */
	public boolean hasPrevious() 
	{
		return (previous != null);
	}

	/**
	 * @return Train that would be previous
	 */
	public Train getPrevious() 
	{
		if(!hasPrevious()) return null;
		else return previous;
	}

	/**
	 * Make selected Train previous
	 * @param previous of Train
	 */
	public void setPrevious(Train previous) 
	{
		this.previous = previous;
	}

	/**
	 * Move FrontTrain 
	 * @param x
	 * @param y
	 */
	public void moveTo(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	/**
	    Draws the FrontTrain
	    @param g2 the graphics context
	 */
	public void draw(Graphics2D g2)
	{
		x1 = getRect().x;
		y1 = getRect().y;
		Rectangle2D.Double hood = new Rectangle2D.Double(x1, y1 + UNIT, U3, U3 ) ;
		g2.setColor(Color.blue) ;
		g2.fill(hood) ;
		
		Rectangle2D.Double body = new Rectangle2D.Double(x1 + U3, y1, U10, U4) ;
		g2.setColor(Color.blue) ;
		g2.fill(body) ;
		
		Line2D.Double hitch = new Line2D.Double(x1 + U13, y1 + U2_5, x1 + U14, y1 + U2_5) ;
		g2.setColor(Color.black) ;
		g2.draw(hitch) ;
		
		Ellipse2D.Double wheel1 = new Ellipse2D.Double(x1 + U_3, y1 + U4, UNIT, UNIT) ;
		g2.setColor(Color.black) ;
		g2.fill(wheel1) ;
		
		Ellipse2D.Double wheel2 = new Ellipse2D.Double(x1 + 1.3 * UNIT, y1 + U4, UNIT, UNIT) ;
		g2.setColor(Color.black) ;
		g2.fill(wheel2) ;
		
		Ellipse2D.Double wheel3 = new Ellipse2D.Double(x1 + 2.3 * UNIT, y1 + 4 * UNIT, UNIT, UNIT) ;
		g2.setColor(Color.black) ;
		g2.fill(wheel3) ;
		
		Ellipse2D.Double wheel4 = new Ellipse2D.Double(x1 + U10_7, y1 + U4, UNIT, UNIT) ;
		g2.setColor(Color.black) ;
		g2.fill(wheel4) ;
		
		Ellipse2D.Double wheel5 = new Ellipse2D.Double(x1 + U12, y1 + U4, UNIT, UNIT) ;
		g2.setColor(Color.black) ;
		g2.fill(wheel5) ;
		
		Ellipse2D.Double wheel6 = new Ellipse2D.Double(x1 + 9.7 * UNIT, y1 + U4, UNIT, UNIT) ;
		g2.setColor(Color.black) ;
		g2.fill(wheel6) ;

		if(hasNext())
		{
			g2.drawLine(getRect().x, getRect().y, getNext().getRect().x, getNext().getRect().y);	
			getNext().draw(g2);
		}
	}//End Draw method

}//End FrontTrain class