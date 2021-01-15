package task2;

public class Lab2_2 {
    public static void main(String[] args){
        System.out.println("Задача 2. Класс Animal и его потомки");
        Animal[] animals = new Animal[3];
        animals[0] = new Dog("Кости", "Будка", 3);
        animals[1] = new Cat("Колбаса", "Дом", 10);
        animals[2] = new Horse("Овес", "Загон", 100);
        Vet vet = new Vet();
        for (Animal animal: animals){
            vet.treatAnimal(animal); // Срабатывает метод из класса task2.Animal
        }
    }
}
