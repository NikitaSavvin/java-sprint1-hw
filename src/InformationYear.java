import java.util.ArrayList;
import java.util.HashMap;

public class InformationYear {
    public static void printInformationYear(ArrayList<YearRow> data) {
        HashMap<Integer, String> calendar = Calendar.convertNumberToMmonth();
        HashMap<String, String> dataY = null;
        dataY = ProcessorFiles.processYearlyFiles();
        for (int i = 0; i < dataY.size(); i++) {
            for (String numYear : dataY.values()) {
                System.out.println("Рассматривается " + numYear + " год");
            }
            int sumIncome = 0;
            int sumExpenses = 0;
            for (int n = 0; n < data.get(i).month.size(); n += 2) {
                int income = 0;
                int expenses = 0;
                int profit = 0;
                if (data.get(i).month.get(n).equals(data.get(i).month.get(n + 1))) {
                    if (!data.get(i).isExpense.get(n)) {
                        income = data.get(i).amount.get(n);
                        expenses = data.get(i).amount.get(n + 1);
                    } else {
                        income = data.get(i).amount.get(n + 1);
                        expenses = data.get(i).amount.get(n);
                    }
                    profit = income - expenses;
                }
                int numMount = Integer.parseInt(
                        String.valueOf(Integer.parseInt(data.get(i).month.get(n)) - 1)
                );
                System.out.println(
                        "За " + calendar.get(numMount) +
                                " месяц прибыль составила " + profit + " рублей"
                );
                sumIncome += income;
                sumExpenses += expenses;
            }
            int quantityMount = data.get(i).month.size() / 2;
            int mediumIncome = sumIncome / quantityMount;
            int mediumExpense = sumExpenses / quantityMount;
            System.out.println("Средний доход за год составил " + mediumIncome + " рублей");
            System.out.println("Средний расход за год составил " + mediumExpense + " рублей");
        }
    }
}