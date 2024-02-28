public class Car extends Vehicle{
    private int numDoors;

    public Car(String make, String model, int year, int numDoors){
        Vehicle.super(make, model, year);
        this.numDoors = numDoors;
    }

    @Override
    printInfo(){
        
    }
}
