public class Student extends People{
    private String className;
    public Student(String name, int id, int age, String className) {
        super(name, id, age);
        this.className = className;
    }
    public void learn(){ System.out.println("Learning in " + className); }

    @Override
    public void sit() {
        System.out.println("Sitting in the Classroom.");
    }
}