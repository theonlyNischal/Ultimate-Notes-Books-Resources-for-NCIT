interface Exam {
void common_method();

}

class Maths implements Exam{
public void common_method(){
System.out.println("Maths ko exam");
}
};

class Java implements Exam{
public void common_method(){
System.out.println("Java ko exam ");
}
};

class Interface{
public static void main (String[] args){
Maths maths_obj = new Maths();
maths_obj.common_method();
}
};