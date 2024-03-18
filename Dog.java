// CS-280 Sp24
// Derek Shannon & Sydney Nilles
// Exercise 3/11
// 03/18/2024

public class Dog extends Animal{

    public Dog(String name){
        super(name); //Invokes the superclass constructor
    }
    /* Unable to override method due to final modifier
    @Override
    public void eat(){
        System.out.println("Nom Nom");
    }
    */

    @Override
    public void sleep(){
        System.out.println(this.name + "is sleeping on your bed.");
    }
}
