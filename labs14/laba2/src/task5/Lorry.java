package task5;

class Lorry extends Car {
    public Lorry(String model, String carClass, double weight, Engine engine) {
        super(model, carClass, weight, engine);
    }

    @Override
    void start() {
        System.out.println("Cargo stop");
    }

    @Override
    void stop() {
        System.out.println("Cargo go");
    }


}
