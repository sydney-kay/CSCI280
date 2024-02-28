// CS-280 Sp24
// Derek Shannon & Sydney Nilles
// Assignment #6
// 03/01/2024

public class Motorcycle extends Vehicle{
    private Boolean isCruiser;

    public Motorcycle(String make, String model, int year, Boolean isCruiser){
        super(make, model, year);
        this.isCruiser = isCruiser;
    }

    @Override
    public void printInfo(){
        System.out.printf("Year: %s\nMake: %S\nModel: %S\nCruiser: %S\n\n", year, make, model, isCruiser);
    }
}
