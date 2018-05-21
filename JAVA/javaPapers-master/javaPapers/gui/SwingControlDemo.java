import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class SwingControlDemo {
    
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;

   public SwingControlDemo(){
      prepareGUI();
   }

   public static void main(String[] args){
      SwingControlDemo  swingControlDemo = new SwingControlDemo();      
      swingControlDemo.showFileChooserDemo();
   }

   private void prepareGUI(){
      mainFrame = new JFrame("Java Swing Examples");
      mainFrame.setSize(400,400);
      mainFrame.setLayout(new GridLayout(3, 1));
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      headerLabel = new JLabel("", JLabel.CENTER);        
      statusLabel = new JLabel("",JLabel.CENTER);    

      statusLabel.setSize(350,100);

      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);  
   }

   private void showFileChooserDemo(){
      headerLabel.setText("Control in action: JFileChooser"); 
    
    /*resize image and display in a label
      JFileChooser fchose=new JFileChooser();
        //}
          int returnVal = fchose.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
               java.io.File file = fchose.getSelectedFile();
               ImageIcon img=new ImageIcon(file.toString());
               Image img1=img.getImage();
               Image newimg=img1.getScaledInstance(200, 200, java.awt.Image.SCALE_AREA_AVERAGING);
               ImageIcon newIcon=new ImageIcon(newimg);
               jLabel1.setIcon(newIcon);
               
            }
            */
      
      
      final JFileChooser  fileDialog = new JFileChooser();
      JButton showFileDialogButton = new JButton("Open File");
      showFileDialogButton.addActionListener(new ActionListener() {
       //  @Override
         public void actionPerformed(ActionEvent e) {
            int returnVal = fileDialog.showOpenDialog(mainFrame);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
               java.io.File file = fileDialog.getSelectedFile();
               ImageIcon img=new ImageIcon(file.toString());
               statusLabel.setIcon(img);
             //  statusLabel.setText("File Selected :" 
               //+ file.getName());
            }
            else{
               statusLabel.setText("Open command cancelled by user." );           
            }      
         }
      });
      controlPanel.add(showFileDialogButton);
      mainFrame.setVisible(true);  
   }
}