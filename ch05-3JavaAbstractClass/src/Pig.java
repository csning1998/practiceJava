public class Pig extends Animal implements Edible{
    public Pig(){
        super("Pig");
    }

    @Override
    public void makeSound(){
        System.out.println("Oink!");
    }
    @Override
    public String youMayEat(){
        return "You may eat pork chops.";
    }

}
