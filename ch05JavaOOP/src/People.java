public class People {
    protected String name;
    protected int id;
    protected int age;
    public People(String name, int id, int age){
        this.name = name;
        this.id = id;
        this.age = age;
    }
    public void sit(){ System.out.println("Sitting..."); }
    public void eat(){ System.out.println("Eating..."); }
    @Override
    public boolean equals(Object p) {
        if (p instanceof People someoneAge){
            return this.age == someoneAge.age;
        } else {
            return false;
        }
    }
}
