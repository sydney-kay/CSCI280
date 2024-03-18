// CS-280 Sp24
// Derek Shannon & Sydney Nilles
// Exercise 3/11
// 03/18/2024

public class Dog extends Animal{
    
    public Dog(String name){
        super(name); //Invokes the superclass constructor
    }

    /*@Override
    public void eat(){  // taking this out of a comment will cause an error
        System.out.println("Nom Nom");
    }*/

    @Override
    public void sleep(){
        System.out.println("zzzzzzzzzzz");
    }
}
