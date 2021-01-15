package task2;

class Horse extends Animal {
    int maxSpeed;

    public Horse(String food, String location, int maxSpeed) {
        super(food, location);
        this.maxSpeed = maxSpeed;
    }

    public Horse(String food, String location) {
        super(food, location);
    }

    @Override
    public void makeNoise() {
        System.out.println("Лошадь ржет");
    }

    @Override
    public void eat() {
        System.out.println("Лошадь ест " + food);
    }

    @Override
    public void sleep() {
        System.out.println("Лошадь спит стоя");
    }
}
