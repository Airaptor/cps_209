
import javax.swing.JFrame;

/**
   This program uses a menu to display font effects.
*/
public class FontViewer
{  
   public static void main(String[] args)
   {  
      JFrame frame = new FontFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setTitle("FontViewer");
      frame.setVisible(true);      
   }
}

