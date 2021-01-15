package task5;

public abstract class Car {
    String model;
    String carClass;
    double weight;
    Engine engine;

    public Car(String model, String carClass, double weight, Engine engine) {
        this.model = model;
        this.carClass = carClass;
        this.weight = weight;
        this.engine = engine;
    }

    abstract void start();
    abstract void stop();
    void turnRight(){
        System.out.println("turnRight");
    }
    void turnLeft() {
        System.out.println("turnLeft");
    }

    void printInfo() {
        System.out.println("model: "+model);
        System.out.println("carClass: " + carClass);
        System.out.println("weight: " + weight);
        System.out.println("engine power: " + engine.power);
        System.out.println("engine.manufacturer: " + engine.manufacturer);
    }
}

