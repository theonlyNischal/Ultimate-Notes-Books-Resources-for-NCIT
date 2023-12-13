public class DateTest {
    public static void main( String [] args )
    {
        Date date1  = new Date(8,28,2000);
        System.out.println("The Initial Date ");
        date1.displayDate();


        date1.setMonth(2);
        date1.setDay(12);
        date1.setYear(2003);

        System.out.println("\nThe Updated Date ");
        date1.displayDate();




    }
}
