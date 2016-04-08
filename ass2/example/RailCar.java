import java.awt.* ;
import java.awt.geom.* ;

/**
   This class describes a vehicle that looks like a flatbed 
   railcar.  The railcar should be assigned a unique number 
   displayed on its body. The railcar should have variable and 
   methods to allow it to be linked to another vehicle (consider
   whether this variable and associated methods should be
   inherited). This railcar should also have variables and
   methods so that a storage container can be loaded and unloaded
   Add other variables and methods you think are necessary.
 */

public class RailCar
{
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
       Draw the rail car
       @param g2 the graphics context
     */
    public void draw(Graphics2D g2)
    {
	// think about whether getX() and getY() should be inherited
     // or defined in this class
	int xLeft = getX() ;
	int yTop = getY() ;
	
	Rectangle2D.Double body 
	    = new Rectangle2D.Double(getX(), yTop + UNIT, U6, UNIT);      
	Ellipse2D.Double frontTire 
	    = new Ellipse2D.Double(getX() + UNIT, yTop + U2, UNIT, UNIT);
	Ellipse2D.Double rearTire
	    = new Ellipse2D.Double(getX() + U4, yTop + U2, UNIT, UNIT);
	
	// the bottom of the front windshield
	Point2D.Double r1 
	    = new Point2D.Double(getX() + UNIT, yTop + UNIT);
	// the front of the roof
	Point2D.Double r2 
	    = new Point2D.Double(getX() + U2, yTop);
	// the rear of the roof
	Point2D.Double r3 
	    = new Point2D.Double(getX() + U4, yTop);
	// the bottom of the rear windshield
	Point2D.Double r4 
	    = new Point2D.Double(getX() + U5, yTop + UNIT);

	// the right end of the hitch
	Point2D.Double r5 
	    = new Point2D.Double(getX() + U6, yTop + U15);
	// the left end of the hitch
	Point2D.Double r6 
	    = new Point2D.Double(getX() + U6 + U05, yTop + U15);
	
	Line2D.Double frontWindshield 
	    = new Line2D.Double(r1, r2);
	Line2D.Double roofTop 
	    = new Line2D.Double(r2, r3);
	Line2D.Double rearWindshield
	    = new Line2D.Double(r3, r4);
	Line2D.Double hitch
	    = new Line2D.Double(r5, r6);

	g2.draw(body);
	g2.draw(hitch);
	g2.draw(frontTire);
	g2.draw(rearTire);
	g2.draw(body) ;
	// think about whether getNumber() should be inherited or
	// defined in this class
	g2.drawString("" + getNumber(), getX() + U2, yTop + U2) ;
    }
}
    
    
    
    