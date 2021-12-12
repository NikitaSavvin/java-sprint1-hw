import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public abstract class Main {

    public static void main(String[] args) {
        HashMap<String, String> calendar = Calendar.calendar();
        Scanner scanner = new Scanner(System.in);
        HashMap<ArrayList, HashMap> dataMounts = MonthlyReport.monthlyReport();
        HashMap<String, HashMap> dataYear = YearlyReport.yearlyReport();

        while (true) {
            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                System.out.println("-----------------------Ответ------------------------");
                for (ArrayList date : dataMounts.keySet()) {
                    System.out.println("Отчет за " + calendar.get(date.get(0)));
                    System.out.println(dataMounts.get(date));
                }
            } else if (command == 2) {
                System.out.println("-----------------------Ответ------------------------");
                for (String year : dataYear.keySet()) {
                    System.out.println("Отчет за " + year + " год");
                    System.out.println(dataYear.get(year));
                }
            } else if (command == 3) {
                System.out.println("-----------------------Ответ------------------------");
                VerificationData.verificationData();
            } else if (command == 4) {
                System.out.println("-----------------------Ответ------------------------");
                InformationMonth.informationMonth();
            } else if (command == 5) {
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
        System.out.println("Считать все месячные отчёты команда 1");
        System.out.println("Считать годовой отчёт команда 2");
        System.out.println("Сверить отчёты команда 3");
        System.out.println("Вывести информацию о всех месячных отчётах команда 4");
        System.out.println("Вывести информацию о годовом отчёт команда 5");
        System.out.println("Любое другое число - выход");
        System.out.println("-----------------------------------------------");
        System.out.println("Введите команду");
    }
}
