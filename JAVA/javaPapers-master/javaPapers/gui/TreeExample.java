import javax.swing.*;
import javax.swing.tree.*;


public class TreeExample extends JFrame
{
    private JTree tree;
    public TreeExample()
    {
        //create the root node
      
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        //create the child nodes
        DefaultMutableTreeNode vegetableNode = new DefaultMutableTreeNode("Vegetables");
        vegetableNode.add(new DefaultMutableTreeNode("Capsicum"));
        vegetableNode.add(new DefaultMutableTreeNode("Carrot"));
        vegetableNode.add(new DefaultMutableTreeNode("Tomato"));
        vegetableNode.add(new DefaultMutableTreeNode("Potato"));

        DefaultMutableTreeNode fruitNode = new DefaultMutableTreeNode("Fruits");
        fruitNode.add(new DefaultMutableTreeNode("Banana"));
        fruitNode.add(new DefaultMutableTreeNode("Mango"));
        fruitNode.add(new DefaultMutableTreeNode("Apple"));
        fruitNode.add(new DefaultMutableTreeNode("Grapes"));
        fruitNode.add(new DefaultMutableTreeNode("Orange"));
        
        //add the child nodes to the root node
        root.add(vegetableNode);
        root.add(fruitNode);
        
        //create the tree by passing in the root node
        tree = new JTree(root);
        //add icon to leaf nodes
        ImageIcon imageIcon = new ImageIcon("android.png");
        DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
        renderer.setLeafIcon(imageIcon);
        tree.setCellRenderer(renderer);

        tree.setShowsRootHandles(true);//to display the root handle in root node
        JScrollPane jp=new JScrollPane(tree);
        add(jp);
        
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setTitle("JTree Example");        
        pack();
        setVisible(true);
    }
    
    public static void main(String[] args)
    {
      new TreeExample();
    }
}
