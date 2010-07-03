//Zak Killelea
//CS-398

<<<<<<< HEAD
import java.io.BufferedInputStream;
//import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.*;
import javax.swing.SwingUtilities;
//import java.awt.*;
//import java.awt.event.*;
  
public class loader extends JPanel {
  static private final String newline = "\n";
  static private final long serialVersionUID = 1;
  static private JFileChooser fc;
  
  public loader() {
    //super(new BorderLayout());

    //Create a file chooser
    fc = new JFileChooser();
    fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
    
    //JPanel buttonPanel = new JPanel(); //use FlowLayout
    
  }

  public static void main(String args[]) {
    
 //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE); 
                createAndShowGUI();
            }
        });
                
    //Open Dialog box for fileChooser
    //fc.showOpenDialog(loader.this);
    
    File file = fc.getSelectedFile();
    
    //File file = new File();
    FileInputStream fis = null;
    BufferedInputStream bis = null;
    //DataInputStream dis = null;

    try {
      fis = new FileInputStream(file);
      bis = new BufferedInputStream(fis);
//      dis = new DataInputStream(bis);

      while(bis.available() != 0) {
        System.out.println(bis.read());
      }

      fis.close();
      bis.close();
      //dis.close();
    }

    catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  public void dialogBox() {
      //Handle open button action.
      int returnVal = fc.showOpenDialog(loader.this);
      
      if(returnVal == JFileChooser.APPROVE_OPTION) {
        File file = fc.getSelectedFile();
        //This is where a real application would open the file.
        System.out.println("Opening: " + file.getName() + "." + newline);
      }
      else {
        System.out.println("Open command cancelled by user." + newline);
      }
  }
  
   private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("loader");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add content to the window.
        frame.add(new loader());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
=======
public class loader {
  public static void main(String args[]) {
    
  }
>>>>>>> upstream/master
}