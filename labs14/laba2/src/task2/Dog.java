package task2;

class Dog extends Animal {
    int walkingHours; // Количество прогулочных часов

    public Dog(String food, String location, int walkingHours) {
        super(food, location);
        this.walkingHours = walkingHours;
    }

    public Dog(String food, String location) {
        super(food, location);
    }

    @Override
    public void makeNoise() {
        System.out.println("Собака лает");
    }

    @Override
    public void eat() {
        System.out.println("Собака ест " + food);
    }

    @Override
    public void sleep() {
        System.out.println("Собака спит " + location);
    }
}
