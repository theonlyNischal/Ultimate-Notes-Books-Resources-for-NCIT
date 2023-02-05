class SemException extends Exception{
    public SemException(String msg){
        super(msg);
    }
}
class CustomException{
    String name;
    int sem;
    public CustomException(String name,int sem) throws SemException{
        if(sem<1 || sem>8){
            throw new SemException("Invalid semester!");
        }
        else{
            this.name=name;
            this.sem=sem;
        }
    }
    public void display(){
        System.out.println("Name: "+name+" Sem: "+sem);
    }
    public static void main(String [] args){
        try{
            CustomException c=new CustomException("Kamal", 10);
            c.display();
        }catch(SemException e){
            System.out.println(e.getMessage());
        }
    }
}