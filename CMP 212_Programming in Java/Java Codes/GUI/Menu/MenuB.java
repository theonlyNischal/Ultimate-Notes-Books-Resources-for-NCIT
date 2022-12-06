
// Menu Program

import java.awt.*;
import java.awt.event.*;

class MenuB extends Frame{
    Menu file,edit,n;
    MenuItem save,exit,java,laravel;
    MenuBar bar;
    public MenuB(){
        setSize(800,1000);
        bar = new MenuBar();
        setMenuBar(bar);
        Menu file = new Menu("File");
        bar.add(file);
        Menu edit = new Menu("Edit");
        bar.add(edit);
        n = new Menu("New");
        file.add(n);
        save = new MenuItem("Save");
        file.add(save);
        exit = new MenuItem("Exit");
        file.add(exit);
        java = new MenuItem("Java");
        n.add(java);
        laravel = new MenuItem("Laravel");
        n.add(laravel);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String args[]) {
        new MenuB();
    }
}