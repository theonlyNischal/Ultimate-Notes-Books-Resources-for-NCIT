class Rectangle{
	int l, b;
	public Rectangle(int l, int b){
		this.l=l;
		this.b=b;
	}
	public void area(){
		System.out.println("Area: "+ (this.l*this.b));
	}
	public void perimeter(){
		System.out.println("Perimeter: "+ (2*(this.l+this.b)));
	}
}
class Square extends Rectangle{
	public Square(int len){
		super(len,len);
	}
	public static void main(String[] args){
		Rectangle r=new Rectangle(9,5);
		Square s=new Square(6);
		System.out.println("For rectangle: ");
		r.area();
		r.perimeter();
		System.out.println();
		s.area();
		s.perimeter();
	}
}