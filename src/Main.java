import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public abstract class Main {
    public static void main(String[] args) {
        HashMap<Integer, String> calendar = Calendar.convertNumberToMmonth();
        Scanner scanner = new Scanner(System.in);
        ArrayList<MonthRow> dataMount = null;
        ArrayList<YearRow> dataYear = null;
        for (YearRow yearRow : dataYear = YearlyReport.creatDataYearlyReport()) {
            System.out.println(yearRow);
        }

        while (true) {
            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                System.out.println("-----------------------Ответ------------------------");
                dataMount = MonthlyReport.creatDataMonthlyReport();
                for (int i = 0; i < dataMount.size(); i++) {
                    System.out.println("--------------------------------------------------------");
                    System.out.println("Отчет за " + calendar.get(i));
                    System.out.println("Номенклатура");
                    System.out.println(dataMount.get(i).itemName);
                    System.out.println("Доходы-false/Расходы-true");
                    System.out.println(dataMount.get(i).isExpense);
                    System.out.println("Количество");
                    System.out.println(dataMount.get(i).quantity);
                    System.out.println("Цена шт");
                    System.out.println(dataMount.get(i).sumOfOne);
                    System.out.println("--------------------------------------------------------");
                }
            } else if (command == 2) {
                System.out.println("-----------------------Ответ------------------------");
                dataYear = YearlyReport.creatDataYearlyReport();
                HashMap<String, String> dataY = ProcessorFiles.processYearlyFiles();
                for (String year : dataY.values()) {
                    System.out.println("--------------------------------------------------------");
                    System.out.println("Отчет за " + year + " год");
                    for (int i = 0; i < dataY.size(); i++) {
                        System.out.println("Номера месяцев");
                        System.out.println(dataYear.get(i).month);
                        System.out.println("Доходы/расходы");
                        System.out.println(dataYear.get(i).amount);
                        System.out.println("Доходы-false/Расходы-true");
                        System.out.println(dataYear.get(i).isExpense);
                    }
                    System.out.println("--------------------------------------------------------");
                }
            } else if (command == 3) {
                System.out.println("-----------------------Ответ------------------------");
                try {
                    VerificationData.printVerificationData(dataMount, dataYear);
                } catch (NullPointerException e) {
                    printErrorCommand3();
                }
            } else if (command == 4) {
                System.out.println("-----------------------Ответ------------------------");
                try {
                    InformationMonth.printInformationMonth(dataMount);
                } catch (NullPointerException e) {
                    printErrorCommand4();
                }
            } else if (command == 5) {
                System.out.println("-----------------------Ответ------------------------");
                try {
                    InformationYear.printInformationYear(dataYear);
                } catch (NullPointerException e) {
                    printErrorCommand5();
                }
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

    public static void printErrorCommand3() {
        System.out.println("Ошибка. Вы не считали месячный или годовой отчет.");
        System.out.println("Убедитесь в том что месячный и годовоц отчет считаны и");
        System.out.println("повторите попытку снова");
    }

    public static void printErrorCommand4() {
        System.out.println("Ошибка. Вы не считали месячный отчет.");
        System.out.println("Убедитесь в том что Вы считали месячный отчет и");
        System.out.println("повторите попытку снова");
    }

    public static void printErrorCommand5() {
        System.out.println("Ошибка. Вы не считали годовой отчет.");
        System.out.println("Убедитесь в том что Вы считали годовой отчет и");
        System.out.println("повторите попытку снова");
    }
}

