enum Book
{
  Java("Herbert Schieldt",1000),VB("Balaguraswamay",300),C("Deitel and Deitel",400);
  private int price;
  private String author;
  Book(String author,int p)
  {
    this.author=author;
    price=p;
  }
  public int getPrice()
  {
    return price;
  }
  public String getAuthor()
  {
    return author;
  }
}
class EnumTest
{
  public static void main(String args[])
  {
    Book b1=Book.Java;
    System.out.println("Author: "+b1.getAuthor());
    System.out.println("Price: "+b1.getPrice());
  }
}