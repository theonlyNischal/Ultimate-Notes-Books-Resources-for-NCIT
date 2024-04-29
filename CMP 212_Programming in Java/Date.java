/*
This is the question number 6 in the java assignment
the object code can be found as the DateTest class.
refer the DateTest Class to have a good idea regarding this code and use of constructer, set&get methods used.
 */
public class Date {
    private int month,day,year;

    public  Date(int month, int day, int year)
    {
       this.month=month;
       this.day=day;
       this.year=year;

    }

    //Getter Method for Month
   public int getMonth()
   {
       return month;
   }

   // Setter Method for Month
    public void setMonth(int month)
    {
        this.month=month;
    }

    //Gettter Method for Day
    public int getDay()
    {
        return day;
    }

    //Setter Method for Day
    public void setDay(int day)
    {
        this.day=day;
    }


    //Getter Method for Year
    public int getYear()
    {
        return year;
    }

    //Setter Method for Year
    public void setYear(int year)
    {
        this.year=year;
    }

    public void displayDate()
    {
        System.out.print(" "+month);
        System.out.print("/"+day);
        System.out.print("/"+year);
    }







}
