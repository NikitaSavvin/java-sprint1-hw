import java.util.ArrayList;

public class YearRow {
    ArrayList<String> month;
    ArrayList<Integer> amount;
    ArrayList<Boolean> isExpense;


    YearRow(ArrayList<String> month, ArrayList<Integer> amount, ArrayList<Boolean> isExpense) {
        this.month = month;
        this.amount = amount;
        this.isExpense = isExpense;
    }
}
