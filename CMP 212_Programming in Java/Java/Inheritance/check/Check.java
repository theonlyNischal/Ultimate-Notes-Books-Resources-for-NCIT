
class Check{
	private String s1="private of Check";
	public static void main(String[] args){
		Check obj=new Check();
		Checking op=new Checking();
		System.out.println(obj.s1 + "\n" + op.s2 + "\n" + op.s3 + "\n" + op.s4);
		//System.out.println(op.str); //error: str has private access in Checking
	}
}
class Checking{
	private String str="Not accessable";
	String s2="default of Checking";
	protected String s3 = "protected of Checking";
	public String s4="valid anywhere";
}
