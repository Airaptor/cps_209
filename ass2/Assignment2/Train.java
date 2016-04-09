import java.awt.Graphics2D;
import java.awt.Rectangle;


/**
 * Abstract of class Train allowing draw,create,and moving
 */
abstract class Train 
{
	public static final int TRAIN_WIDTH = 105;
	public static final int TRAIN_HEIGHT = 50;
	public static final int CART_WIDTH = 70;
	public static final int CART_HEIGHT = 50;
	public int x;
	public int y;
	public Train next, previous;

	/**
	 * The constructor for the Train class
	 * @param xPos x coordinate of rectangle
	 * @param yPos y coordinate of rectangle
	 * @param next Train is pointing to
	 */
	public Train(int xPos, int yPos, Train next)
	{
		x = xPos;
		y = yPos;
		this.next = next;
		previous = null;
	}//End constructor

	/**
	 * Draws Train 
	 * @param g2
	 */
	abstract public void draw(Graphics2D g2);

	/**
	 * Gets the bounding box around Train
	 * @return the bounding rectangle
	 */
	abstract public Rectangle getRect();

	/**
	 * Gets whether this Train points to another Train or not
	 * @return whether this Train points to another Train or not
	 */
	abstract public boolean hasNext();

	/**
	 * Gets the Train this Train points to
	 * @return the Train this Train points to
	 */
	abstract public Train getNext();

	/**
	 * Sets the Train this Train points to
	 */
	abstract public void setNext(Train next);

	/**
	 * Gets whether this Train has a previous Train
	 * @return whether this Train has a previous Train
	 */
	abstract public boolean hasPrevious();

	/**
	 * Gets the previous Train of this Train
	 * @return the previous Train of this Train
	 */
	abstract public Train getPrevious();

	/**
	 * Sets the Train which points to this Train
	 */
	abstract public void setPrevious(Train previous);

	/**
	 * Moves the Train to a new position
	 * @param x coordinate
	 * @param y coordinate
	 */
	abstract public void moveTo(int x, int y);

	/**
	 * Moves the x value of Train
	 * @param x coordinate
	 */
	public void moveX(int x)
	{
		this.x += x;
	}

	/**
	 * Moves the y value of Train
	 * @param y coordinate
	 */
	public void moveY(int y)
	{
		this.y += y;
	}

	/**
	 * Moves x and y in random d
	 * @param x
	 * @param y
	 */

}//End Train class
