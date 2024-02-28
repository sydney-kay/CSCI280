// CS-280 Sp24
// Derek Shannon & Sydney Nilles
// Assignment #6
// 03/01/2024

public class Vehicle {
    protected String make;
    protected String model;
    protected int year;

    public Vehicle(String make, String model, int year){
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public void printInfo(){
        System.out.printf("Year: %d\nMake: %S\nModel: %S\n", year, make, model);
    }
}
