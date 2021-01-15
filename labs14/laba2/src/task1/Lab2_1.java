package task1;

public class Lab2_1 {
    public static void main(String[] args) {
        Phone[] phones = new Phone[3];
        // Первый телефон


        phones[0] = new Phone();
        phones[0].number = "+79109365880";
        phones[0].model = "Meizu";
        phones[0].weight = 200;
        // Второй телефон


        phones[1] = new Phone("+79108368008","Model1");
        phones[1].weight = 450;
        // Третий телефон
        // спросить про считывание номера с телефона



        phones[2] = new Phone("+79106374707","Model2", 520);
        for (Phone p: phones) {
            System.out.println(p.number + ": "+ p.model+"weight "+ p.weight );

        }
        phones[0].receiveCall("task3.Student");
        phones[0].receiveCall("task3.Student", "+798531872");
        phones[0].sendMessage("+7963905466","+7904896545");
    }

}


