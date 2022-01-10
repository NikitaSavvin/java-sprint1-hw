import java.util.ArrayList;
import java.util.HashMap;

public class VerificationData {
    public static void printVerificationData(
            ArrayList<MonthRow> dataMount, ArrayList<YearRow> dataYear
    ) {
        ArrayList<Boolean> accounting = new ArrayList<>();
        HashMap<Integer, String> calendar = Calendar.convertNumberToMmonth();
        ArrayList<ArrayList> dataYearIncomeExpenses = createListIncomeExpenses(dataYear);
        for (int i = 0; i < dataMount.size(); i++) {
            int incomeMountFromYear = (int) dataYearIncomeExpenses.get(i).get(0);
            int expensesMountFromYear = (int) dataYearIncomeExpenses.get(i).get(1);
            int incomeMount = 0;
            int expensesMount = 0;
            for (int n = 0; n < dataMount.get(i).itemName.size(); n++) {
                int sum = dataMount.get(i).quantity.get(n) * dataMount.get(i).sumOfOne.get(n);
                if (!dataMount.get(i).isExpense.get(n)) {
                    incomeMount += sum;
                } else {
                    expensesMount += sum;
                }
            }
            if (incomeMount != incomeMountFromYear || expensesMount != expensesMountFromYear) {
                accounting.add(false);
            } else {
                accounting.add(true);
            }
        }
        if (accounting.contains(false)) {
            for (int i = 0; i < accounting.size(); i++) {
                if (accounting.get(i) == false) {
                    System.out.println("В месяце " + calendar.get(i) + " обнаружено несоответствие");
                }
            }
        } else {
            System.out.println("Операция завершена успешно");
        }
    }

    public static ArrayList<ArrayList> createListIncomeExpenses(ArrayList<YearRow> dataYear) {
        ArrayList<ArrayList> dataYearIncomeExpenses = new ArrayList<>();
        HashMap<String, String> dataY = null;
        dataY = ProcessorFiles.processYearlyFiles();
        for (int i = 0; i < dataY.size(); i++) {
            int sumIncome = 0;
            int sumExpenses = 0;
            ArrayList<Integer> IncomeExpenses = null;
            for (int n = 0; n < dataYear.get(i).month.size(); n += 2) {
                IncomeExpenses = new ArrayList<>();
                int income = 0;
                int expenses = 0;
                if (dataYear.get(i).month.get(n).equals(dataYear.get(i).month.get(n + 1))) {
                    if (!dataYear.get(i).isExpense.get(n)) {
                        income = dataYear.get(i).amount.get(n);
                        expenses = dataYear.get(i).amount.get(n + 1);
                    } else {
                        income = dataYear.get(i).amount.get(n + 1);
                        expenses = dataYear.get(i).amount.get(n);
                    }
                }
                IncomeExpenses.add(income);
                IncomeExpenses.add(expenses);
                dataYearIncomeExpenses.add(IncomeExpenses);
            }
        }
        return dataYearIncomeExpenses;
    }
}
