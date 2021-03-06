import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;



/**
   This program uses a menu to display truck and car effects.
 */
@SuppressWarnings("serial")
public class GraphicLinkedViewer extends JFrame
{  
	private static final int FRAME_WIDTH = 1000;
	private static final int FRAME_HEIGHT = 1000;
	private GraphicLinkedPanel panel;
	private JLabel label;
	private String facename;

	public GraphicLinkedViewer()
	{
		setTitle("Assignment 2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new GraphicLinkedPanel();
		add(panel);
		setVisible(true);
		
		JMenuBar menuBar = new JMenuBar();     
		setJMenuBar(menuBar);
		menuBar.add(createFileMenu());
		menuBar.add(createQueueMenu());
		menuBar.add(createListMenu());
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}//End Constructor

	/**
	 * Exits Java
	 */
	class ExitItemListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			System.exit(0);
		}
	}
	
	/**
	 *Clears the screen of the Train
	 */
	class NewItemListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			panel.clearList();
		}
	}

	/**
	      Creates the File menu.
	      @return the menu
	 */
	public JMenu createFileMenu()
	{
		JMenu menu = new JMenu("File");
		JMenuItem exitItem = new JMenuItem("Exit");
		JMenuItem newItem = new JMenuItem("New");
		ActionListener listener = new ExitItemListener();
		exitItem.addActionListener(listener);
		ActionListener newListener = new NewItemListener();
		newItem.addActionListener(newListener);
		menu.add(newItem);
		menu.add(exitItem);
		return menu;
	}

	/**
	      Creates the List sub menu.
	      @return the menu
	 */
	public JMenu createListMenu()
	{
		JMenu menu = new JMenu("List");
		menu.add(createAddFirst("Add First"));
		menu.add(createAddLast("Add Last"));
		menu.add(createRemoveFirst("Remove First"));
		menu.add(createRemoveLast("Remove Last"));
		return menu;
	}

	/**
	 * Add the cart to the front
	 * @param name
	 * @return the menu
	 */
	public JMenuItem createAddFirst(final String name)
	{
		class FaceItemListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				// Description of what it should do :(
				facename = name;			
				JOptionPane.showMessageDialog(null, "Add cart that is pressed to FrontTrains location + FrontTrains width. ");
				System.out.println("Add first. \n If previous then add the prev cart to location + firstCart width");
				/*
				 * Complete with function for add first	
				 * panel.moveXDir(80); (moves x by 80)
				*/
			}
		}      

		JMenuItem item = new JMenuItem(name);      
		ActionListener listener = new FaceItemListener();
		item.addActionListener(listener);
		return item;
	}

	/**
	 * Add the car last
	 * @param name
	 * @return the menu
	 */
	public JMenuItem createAddLast(final String name)
	{
		class FaceItemListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				// Description of what it should do :(
				facename = name;
				JOptionPane.showMessageDialog(null, "Add cart that is pressed to FrontTrains location + width + previous cart.\nAdd Last. \n If no previous then add the prev cart to location + FrontTrains ");
				System.out.println("Add Last. \n If no previous then add the prev cart to location + FrontTrains ");

			}
		}      

		JMenuItem item = new JMenuItem(name);      
		ActionListener listener = new FaceItemListener();
		item.addActionListener(listener);
		return item;
	}

	/**
	 * Removes the first car
	 * @param name
	 * @return the menu
	 */
	public JMenuItem createRemoveFirst(final String name)
	{
		class FaceItemListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				// Description of what it should do :(
				facename = name;
				JOptionPane.showMessageDialog(null, "Remove the cart that is the first in FrontTrains location \n remove First.");
				System.out.println("remove First.");

			}
		}      

		JMenuItem item = new JMenuItem(name);      
		ActionListener listener = new FaceItemListener();
		item.addActionListener(listener);
		return item;
	}

	/**
	 * Removes the last car added
	 * @param name
	 * @return the menu
	 */
	public JMenuItem createRemoveLast(final String name)
	{
		class FaceItemListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				// Description of what it should do :(
				facename = name;
				JOptionPane.showMessageDialog(null, "Remove the cart that is the last in FrontTrains list \n remove last.");
				System.out.println("remove Last.");

			}
		}      

		JMenuItem item = new JMenuItem(name);      
		ActionListener listener = new FaceItemListener();
		item.addActionListener(listener);
		return item;
	}

	/**
	 * Creates the Queue Menu
	 * @return the menu
	 */
	public JMenu createQueueMenu()
	{
		JMenu menu = new JMenu("Queue");
		menu.add(createRemove("remove"));
		menu.add(createAdd("add"));
		return menu;
	}


	/**
	 * Creates remove function
	 * @param name
	 * @return item
	 */
	public JMenuItem createRemove(final String name)
	{
		class FaceItemListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				// Description of what it should do :(
				System.out.println("queue remove");
				JOptionPane.showMessageDialog(null, "Take the lowest block and place it in the first cart created that has no blocks");

			}
		}      
		JMenuItem item = new JMenuItem(name);      
		ActionListener listener = new FaceItemListener();
		item.addActionListener(listener);
		return item;
	}
	
	/**
	 *  Creates add function
	 *  @param name 
	 *  @return the menu item
	 */
	public JMenuItem createAdd(final String name)
	{
		class FaceItemListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				// Description of what it should do :(
				facename = name;
				System.out.println("queue add");
				JOptionPane.showMessageDialog(null, "Take the block on top of the selected cart and place it on top of the stack");

			}
		}      
		JMenuItem item = new JMenuItem(name);      
		ActionListener listener = new FaceItemListener();
		item.addActionListener(listener);
		return item;
	}
	

	public static void main(String[] args)
	{  
		@SuppressWarnings("unused")
		GraphicLinkedViewer MyMain = new GraphicLinkedViewer();

	}//End Main

}//End GraphicLinkedViewer Class
