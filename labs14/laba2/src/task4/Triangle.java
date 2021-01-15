package task4;

class Triangle implements Shape {
    double a, b, c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double square() {
        return Math.sqrt(p() * (p() - a) * (p() - b) * (p() - c));
    }

    private double p() {
        return (a + b + c) / 2;
    }
}
