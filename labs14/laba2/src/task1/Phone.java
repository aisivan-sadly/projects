package task1;

import java.util.Random;

public class Phone {
    public String number;
    public String model;
    public int weight;

    public Phone(String number, String model, int weight) {
        this(number, model);
        this.weight = weight;
    }

    public Phone(String number, String model) {
        this.number = number;
        this.model = model;
    }

    public Phone() {
        number = "Unknown";
        model = "Unknown";
        weight = (new Random()).nextInt();
    }

    public void receiveCall(String callerName) {
        System.out.println("Звонит "+callerName);
    }

    public void receiveCall(String callerName, String number){
        System.out.println("call from number "+callerName+" number " + number);
    }

    public void sendMessage(String... numbers){
        for (String number : numbers) {
            System.out.println("call "+ number);
        }
    }

    public String getNumber() {
        return number;
    }
}
