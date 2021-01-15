package task3;

public class Lab2_3 {
    public static void main(String[] args) {
        Student[] students = new Student[4];
        students[0] = new Student("Ivan", "Kiselev", "A11",4.5);
        students[1] = new Student("Alex", "Ivanov", "B22",5);
        students[2] = new Aspirant("Ivan", "Cheladin", "C33",4.2);
        students[3] = new Aspirant("Angelina", "Semenova", "B44",5);
        for(Student s: students){
            System.out.println("grant " + s.firstName+ " " + s.lastName+" is " + s.getScholarship());
        }
    }
}
