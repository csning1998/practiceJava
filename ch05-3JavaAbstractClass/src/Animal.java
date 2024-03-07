public abstract class Animal {
    protected String animalName;
    public Animal(String animalName){
        this.animalName = animalName;
    }
    public void sleep(){
        System.out.println(animalName + " is sleeping.");
    }
//     If there exist an abstract method in the class, then it should be declared as abstract class.
//     All subclass that extends the Animal class should override this method.
    public abstract void makeSound();
}
