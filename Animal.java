// CS-280 Sp24
// Derek Shannon & Sydney Nilles
// Exercise 3/11
// 03/18/2024

public class Animal {
    protected String name;

    public Animal (String name){
        this.name = name;
    }

    //used final to prevent overriding in subclasses
    public final void eat(){
        System.out.println(name + " is eating.");
    }

    public void sleep(){
        System.out.println(name + " is sleeping.");
    }
}
