class Exception
{
public static void main(String[] args){
 
try
{
System.out.println("The division operation is "+ 5/0); //arithmetic error will occur for sure.
} //try block
catch(ArithmeticException e)
{
 System.out.println("Exception catch garyo hai guys");
}// catch block

finally{
 System.out.println("Finally block ma cham hai guys hami ");
} // finally block
}//main function
} //end of class