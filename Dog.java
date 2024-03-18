public class Dog extends Animal{
    public Dog(String name){
        Animal.super(name);
    }
    @Override
    public void eat(){
        System.out.println("Nom Nom");
    }
    public void sleep(){
        System.out.println("zzzzzzzzzzz");
    }
}
