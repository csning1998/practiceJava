public class Main{
    public static void main(String[] args) {

        Pig food = new Pig();
        System.out.println(food.youMayEat());
        food.makeSound();

        Animal dog1 = new Dog();
        Dog dog2 = new Dog();
        Animal cat1 = new Cat();
        Cat cat2 = new Cat();

        dog1.makeSound();
        System.out.println(dog2.animalName);
        dog2.makeSound();
        cat1.makeSound();
        cat2.sleep();
    }
}