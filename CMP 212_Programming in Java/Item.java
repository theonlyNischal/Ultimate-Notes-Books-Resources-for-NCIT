/*
This is the 7th Question of the assignment
 */
public class Item {
    protected static int Location;
    protected static String Description;

    //constructor - method
    public Item (int Location, String Description)
    {
        this.Description =Description;
        this.Location = Location;
    }

    // Getter Method for Location

    public static int getLocation()
    {
        return Location;
    }

    //Setter Method for Location

    public static void setLocation(int Location)
    {
        Item.Location = Location;
    }


    //Getter Method for Description

    public static String getDescription()
    {
        return Description;
    }

    //Setter Method for Description

    public static void setDescription(String Description)
    {
        Item.Description = Description;
    }




}
