import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        People t1 = new Teacher("ChiHua", 152273, 43, "Java");
        People t2 = new Teacher("David", 100002, 50, "Deep Learning");
        People s1 = new Student("Kevin", 51021001, 19, "Java");
        People s2 = new Student("Joeman", 51021002, 20, "Java");

        // ArrayList
        ArrayList<People> peopleInSchool = new ArrayList<>();
        peopleInSchool.add(t1);
        peopleInSchool.add(t2);
        peopleInSchool.add(s1);
        peopleInSchool.add(s2);

        for(People p: peopleInSchool){
            System.out.println(p.name);
        }
    }
}