public class Motorcycle extends Vehicle{
    private Boolean isCruiser;

    public Motorcycle(String make, String model, int year, Boolean isCruiser){
        super(make, model, year);
        this.isCruiser = isCruiser;
    }

    @Override
    public void printInfo(){
        
    }
}
