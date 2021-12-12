import java.util.Scanner;

public abstract class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                System.out.println("-----------------------Ответ------------------------");
                VerificationData.verificationData();
            } else if (command == 2) {
                System.out.println("-----------------------Ответ------------------------");
                InformationMonth.informationMonth();
            } else if (command == 3) {
                System.out.println("-----------------------Ответ------------------------");
                InformationYear.informationYear();
            } else {
                System.out.println("Выход");
                break;
            }
        }

    }

    public static void printMenu() {
        System.out.println("------------------Функционал-------------------");
        System.out.println("Сверка данных команда 1");
        System.out.println("Информация о всех месячных отчётах команда 2");
        System.out.println("Информация о годовом отчёте команда 3");
        System.out.println("Любое другое число - выход");
        System.out.println("-----------------------------------------------");
        System.out.println("Введите команду");
    }
}
