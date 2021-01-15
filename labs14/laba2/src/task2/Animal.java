package task2;

public class Animal {
    String food;
    String location;

    public Animal(String food, String location) {
        this.food = food;
        this.location = location;
    }

    public void makeNoise(){
        System.out.println("Животное орет");
    }
    public void eat() {
        System.out.println("Животное ест " + food );
    }

    public void sleep() {
        System.out.println("Животное уснуло в " + location);
    }
}

