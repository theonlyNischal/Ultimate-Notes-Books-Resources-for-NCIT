import javax.swing.*;
import java.awt.event.*;
public class MyDynamicMenu extends JFrame implements ActionListener, MouseListener{

    JPopupMenu menu;
    JMenuItem select, copy, cut, paste, exit;
    JTextArea area;

    public MyDynamicMenu(){
        menu = new JPopupMenu();
        select = new JMenuItem("Select All");
        copy = new JMenuItem("Copy");
        cut = new JMenuItem("Cut");
        paste = new JMenuItem("Paste");
        exit = new JMenuItem("Exit");
        area = new JTextArea("Pokhara University");
        area.setBounds(140, 300, 150, 100);

        setSize(300, 400);
        add(menu);
        menu.add(select);
        menu.add(copy);
        menu.add(cut);
        menu.add(paste);
        menu.addSeparator();
        menu.add(exit);
        add(area);

        select.addActionListener(this);
        copy.addActionListener(this);
        cut.addActionListener(this);
        paste.addActionListener(this);
        exit.addActionListener(this);
        addMouseListener(this);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    public void mouseClicked(MouseEvent e){
        menu.show(this, e.getX(), e.getY());
    }
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();

        if(source == select){
            area.selectAll();
        }else if(source == copy){
            area.copy();
        }else if(source == cut){
            area.cut();
        }else if(source == paste){
            area.paste();
        }else {
            System.exit(0);
        }
    }
    public void mousePressed(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}

    public static void main(String[] args) {
        new MyDynamicMenu();
    }
    
}
