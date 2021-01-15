package spring;

import exception.NotEnoughMoneyException;
import exception.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import service.AccountService;

import java.util.ArrayList;
import java.util.Scanner;

@SpringBootApplication
public class JavaLab4Spring implements CommandLineRunner {

    @Autowired
    private AccountService accServ;

    public static void main(String[] args) {
        SpringApplication.run(JavaLab4Spring.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner in = new Scanner(System.in);
        boolean run = true;
        System.out.println("Программа управления счетами");
        System.out.println("Возможные команды:");
        System.out.println("1. balance [id] - информация о счете");
        System.out.println("2. withdraw [id] [amount] - снятие денег со счета");
        System.out.println("3. deposit [id] [amount] - внесение денег на счет");
        System.out.println("4. transfer [from] [to] [amount] - перевод денег с счета на счет");
        while (run) {
            System.out.print("Введите команду (для выхода используйте команду quit): ");
            String command = in.nextLine();
            String[] cmdArgs = command.split(" ");
            ArrayList<Integer> numArgs = new ArrayList<>();
            /* Блок проверки аргументов */
            try {
                for (int i = 1; i < cmdArgs.length; i++) {
                    numArgs.add(Integer.parseInt(cmdArgs[i]));
                }
            } catch (NumberFormatException nfe) {
                cmdArgs[0] = "error";
            }
            /* Конец блока проверки */
            switch (cmdArgs[0].toLowerCase()) {
                case "balance":
                    try {
                        if (numArgs.size() != 1) throw new IllegalArgumentException();
                        accServ.balance(numArgs.get(0));

                    } catch (UnknownAccountException uae) {
                        System.out.println("Не существует аккаунт с таким id");
                    } catch (IllegalArgumentException iae) {
                        System.out.println("Неверное количество параметров команды");
                    }
                    break;
                case "withdraw":
                    try {
                        if (numArgs.size() != 2) throw new IllegalArgumentException();
                        accServ.withdraw(numArgs.get(0), numArgs.get(1));
                        System.out.println("Операция успешно выполнена!");
                    } catch (UnknownAccountException uae) {
                        System.out.println("Не существует аккаунт с таким id");
                    } catch (NotEnoughMoneyException neme) {
                        System.out.println("Не достаточно денег на счете");
                    } catch (IllegalArgumentException iae) {
                        System.out.println("Неверное количество параметров команды");
                    }
                    break;
                case "deposit":
                    try {
                        if (numArgs.size() != 2) throw new IllegalArgumentException();
                        accServ.deposit(numArgs.get(0), numArgs.get(1));
                        System.out.println("Операция успешно выполнена!");
                    } catch (UnknownAccountException uae) {
                        System.out.println("Не существует аккаунт с таким id");
                    } catch (IllegalArgumentException iae) {
                        System.out.println("Неверное количество параметров команды");
                    }
                    break;
                case "transfer":
                    try {
                        if (numArgs.size() != 3) throw new IllegalArgumentException();
                        accServ.transfer(numArgs.get(0), numArgs.get(1), numArgs.get(2));
                        System.out.println("Операция успешно выполнена!");
                    } catch (UnknownAccountException uae) {
                        System.out.println("Не существует аккаунт с таким id");
                    } catch (NotEnoughMoneyException neme) {
                        System.out.println("Не достаточно денег на счете");
                    } catch (IllegalArgumentException iae) {
                        System.out.println("Неверное количество параметров команды");
                    }
                    break;
                case "quit":
                    run = false;
                    break;
                default:
                    System.out.println("Неверная команда!");
                    break;
            }
        }
    }
}
