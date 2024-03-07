public class Teacher extends People {
    private String subjectName;
    public Teacher(String name, int id, int age, String subjectName) {
        super(name, id, age); // Superclass
        this.subjectName = subjectName;
    }
    public void teach(){ System.out.println("Teaching " + subjectName); }
}