package task4;

class Circle implements Shape {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double square() {
        return 3.14 * radius * radius;
    }
}
