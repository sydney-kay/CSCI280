// CS-280 Sp24
// Derek Shannon & Sydney Nilles
// Assignment #6
// 03/01/2024

public class Main{
    public static void main(String []args){
        Vehicle vehicle = new Vehicle("Ford", "F150", 2009);
        Car car = new Car("Honda", "Civic", 2021, 4);
        Motorcycle motorcycle = new Motorcycle("Harley", "Road King", 2024, true);
        vehicle.printInfo();
        car.printInfo();
        motorcycle.printInfo();
    }
}