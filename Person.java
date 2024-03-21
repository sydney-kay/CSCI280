// CS-280 Sp24
// Sydney Nilles
// Assignment 7 - due 03/21/2024

public class Person{
    protected String name;
    protected String address;

    // normal constructor
    public Person(String name, String address){
        this.name = name;
        this.address = address;
    }

    // get variables
    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

    // set variables
    public void setName(String newName){
        this.name = newName;
    }

    public void setAddress(String newAddress){
        this.address = newAddress;
    }
}