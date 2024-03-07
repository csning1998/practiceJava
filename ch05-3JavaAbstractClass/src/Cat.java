public class Cat extends Animal {
    // Constructor
    public Cat(){
        super("Cat");
    }

    // Implement the method.
    @Override
    public void makeSound() {
        System.out.println("Meow");
    }
}
