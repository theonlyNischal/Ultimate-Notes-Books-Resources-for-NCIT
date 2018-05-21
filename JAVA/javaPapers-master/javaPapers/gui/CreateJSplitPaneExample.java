
import java.awt.FlowLayout; 

 import java.awt.Panel; 

 import javax.swing.JComboBox; 
 import javax.swing.JFrame; 
 import javax.swing.JSplitPane; 
   
public class CreateJSplitPaneExample { 
    private static void createAndShowGUI() { 
   
       // Create and set up the window. 
         final JFrame frame = new JFrame("Split Pane Example"); 
   
         // Display the window. 
         frame.setSize(200, 200); 
         frame.setVisible(true); 
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
   
        // set flow layout for the frame 
        frame.getContentPane().setLayout(new FlowLayout()); 
  
         String[] options1 = { "Bird", "Cat", "Dog", "Rabbit", "Pig" }; 
        JComboBox combo1 = new JComboBox(options1); 
  
        String[] options2 = { "Car", "Motorcycle", "Airplane", "Boat" }; 
        JComboBox combo2 = new JComboBox(options2); 
   
         Panel panel1 = new Panel(); 
         panel1.add(combo1); 
   
         Panel panel2 = new Panel(); 
         panel2.add(combo2); 
  
         JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panel1, panel2); 
         // JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panel1, panel2); 
   
         frame.getContentPane().add(splitPane); 
   
     } 
   
     public static void main(String[] args) { 

   
   //Schedule a job for the event-dispatching thread: 
   
   //creating and showing this application's GUI. 
   
   javax.swing.SwingUtilities.invokeLater(new Runnable() { 
   
 public void run() { 
   
     createAndShowGUI();  
   
 } 
   
   }); 
     } 
   
 } 
