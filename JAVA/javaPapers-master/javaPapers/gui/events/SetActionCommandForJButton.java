import java.awt.FlowLayout; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import javax.swing.JButton; 
import javax.swing.JFrame; 
 public class SetActionCommandForJButton extends JFrame implements ActionListener { 
   JButton button;
     private static final long serialVersionUID = 1L; 
     public SetActionCommandForJButton() { 
         // set flow layout for the frame 
        this.getContentPane().setLayout(new FlowLayout()); 
          button = new JButton("Java Code Geeks - Java Examples"); 
         //add Button 
        add(button); 
         //set action listeners for buttons 
        button.addActionListener(this); 
         // define a custom short action command for the button 
        button.setActionCommand("Geeks"); 
         // add button to frame 
        add(button); 
    } 
    @Override 
    public void actionPerformed(ActionEvent ae) { 
       String action = ae.getActionCommand(); 
        if (action.equals("Geeks")) { 
            System.out.println("Button pressed!"); 
            button.setActionCommand("No geeks");
        } 
        if(action.equals("No geeks"))
        {     System.out.println("Button pressed again");
          button.setActionCommand("Geeks");
        }
     } 
     private static void createAndShowGUI() { 
   //Create and set up the window. 
   JFrame frame = new SetActionCommandForJButton(); 
  //Display the window. 
  frame.pack(); 
  frame.setVisible(true); 
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
   } 
    public static void main(String[] args) { 
  //Schedule a job for the event-dispatching thread: 
   //creating and showing this application's GUI. 
  javax.swing.SwingUtilities.invokeLater(new Runnable() { 
public void run() { 
   createAndShowGUI();  
} 
 }); 
 }  } 
