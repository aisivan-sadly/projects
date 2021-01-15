package task4;

public class Lab2_4 {
    public static void main(String[] main) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Triangle(3,4,5);
        shapes[1] = new Circle(3);
        shapes[2] = new Rectangle(3,4);
        for (Shape sh: shapes) {
            System.out.println("Scuare "+ sh.square());
        }
    }
}
