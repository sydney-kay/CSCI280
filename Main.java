public class Main {
    public static void main(String[] args){
        Animal steve = new Animal("steve");
        steve.eat();
        steve.sleep();

        Dog joe = new Dog("joe");
        joe.eat(); // taking this out of a comment will cause an error
        joe.sleep();
    }
}
