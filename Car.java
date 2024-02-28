// CS-280 Sp24
// Derek Shannon & Sydney Nilles
// Assignment #6
// 03/01/2024

public class Car extends Vehicle{
    private int numDoors;

    public Car(String make, String model, int year, int numDoors){
        super(make, model, year);
        this.numDoors = numDoors;
    }

    @Override
    public void printInfo(){
        System.out.println(year+" ");
    }
}
