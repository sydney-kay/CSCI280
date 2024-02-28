// CS-280 Sp24
// Derek Shannon & Sydney Nilles
// Assignment #6
// 03/01/2024

public class Vehicle {
    private String make;
    private String model;
    private int year;

    public Vehicle(String make, String model, int year){
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public void printInfo(){
        System.out.println(year + " " + make + " " + model);
    }
}
