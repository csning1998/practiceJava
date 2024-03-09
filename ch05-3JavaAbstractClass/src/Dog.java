public class Dog extends Animal {

    //  default constructor available in 'Animal'
    public Dog(){
        super("Dog");
    }

    // Implement the method in abstract class
    @Override
    public void makeSound(){
        System.out.println("Bark!");
    }
}
