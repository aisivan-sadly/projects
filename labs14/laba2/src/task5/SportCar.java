package task5;

class SportCar extends Car {
    @Override
    void start() {
        System.out.println("Sportcar go");
    }

    public SportCar(String model, String carClass, double weight, Engine engine) {
        super(model, carClass, weight, engine);
    }

    @Override
    void stop() {
        System.out.println("Sportcar stop");
    }
}
