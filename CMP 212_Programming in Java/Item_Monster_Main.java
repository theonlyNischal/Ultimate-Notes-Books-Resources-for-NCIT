/*
This is the main Class that we  created to perform and check all the methods within the monster and Item
class - Question No 7
 */
public class Item_Monster_Main {
    public static void main( String [] args)
    {
        // Creating an Object for Item Class
        Item obj1 = new Item(200,"Kandy");
        System.out.println("Location: " +Item.getLocation());
        System.out.println("Description: " +Item.getDescription());

        //Creating an Object for Monster Class
        Monster obj2 = new Monster(300, "Pasikuda");
        System.out.println("Location: " +Monster.getLocation());
        System.out.println("Description: " +Monster.getDescription());


        System.out.println("");
        //Using Setter Method and Getter Method to Update Item
        Item.setLocation(900);
        Item.setDescription("Canada");
        System.out.println("The Updated Location is: " +Item.getLocation());
        System.out.println("The Updated Description is: " +Item.getDescription());


        //Using Setter and Getter Method to Update Monster
        Monster.setLocation(1500);
        Monster.setDescription("California");
        System.out.println("The Updated Location is: " +Monster.getLocation());
        System.out.println("The Updated Description is: " +Monster.getDescription());


    }
}
