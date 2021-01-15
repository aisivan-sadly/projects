package task2;

class Cat extends Animal {
    int mouseCount; // Кол-во пойманных мышей

    public Cat(String food, String location, int mouseCount) {
        super(food, location);
        this.mouseCount = mouseCount;
    }

    public Cat(String food, String location) {
        super(food, location);
    }

    @Override
    public void makeNoise() {
        System.out.println("Кошка мяукает");
    }

    @Override
    public void eat() {
        System.out.println("Кошка ест " + food);
    }

    @Override
    public void sleep() {
        System.out.println("Кошка спит");
    }

}
