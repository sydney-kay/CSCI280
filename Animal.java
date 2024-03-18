public class Animal {
    private String name;

    public Animal (String name){
        name = this.name;
    }

    public final void eat(){
        System.out.println(name + " is eating.");
    }

    public void sleep(){
        System.out.println(name + " is sleeping.");
    }
}
