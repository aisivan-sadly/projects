package task5;

public class Lab2_5 {
    public static void main(String[] args) {
        Car[] cars = new Car[2];
        Engine[] engines = new Engine[2];
        engines[0] = new Engine(250,"Powerwolf");
        engines[1] = new Engine(150,"ModernDevice");
        cars[0] = new SportCar("A5","Premium",985,engines[0]);
        cars[1] = new Lorry("Benzin2000","Comfort", 600, engines[1]);
        for (Car car: cars) {
            car.printInfo();
        }
    }
}
